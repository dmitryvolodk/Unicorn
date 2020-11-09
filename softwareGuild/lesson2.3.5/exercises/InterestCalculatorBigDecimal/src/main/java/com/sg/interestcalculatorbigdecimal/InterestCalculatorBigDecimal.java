package com.sg.interestcalculatorbigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InterestCalculatorBigDecimal {
    public void calculateInterest(){
        Scanner myScanner = new Scanner(System.in);
        
        int period = 0,
                years = 0,
                quarters = 0,
                months = 0,
                days = 0,
                periodicCoefficient = 0;
        
        BigDecimal annualInterestRateBeforeScale, annualInterestRateScale;
        
        String yearsString = "",
                annualInterestRateString = "";
        
        System.out.println("We will calculate the investment.\n");
        // Ask the user for the input
        System.out.println("The number of years the money is to stay in the fund,#: ");
        yearsString = myScanner.nextLine();
        years = Integer.parseInt(yearsString);
        
        System.out.println("Annual interest rate,%: ");
        annualInterestRateString = myScanner.nextLine();
        annualInterestRateBeforeScale = new BigDecimal(annualInterestRateString);
        annualInterestRateScale = annualInterestRateBeforeScale.setScale(2, RoundingMode.HALF_UP);
        
        System.out.println("How is the interest compounded (quarterly / monthly / daily) ?");
        String compounding = myScanner.nextLine();
        // Identify the coefficient based on the compounding period
        switch(compounding){
            case "quarterly": periodicCoefficient = 4;
                              period = years * periodicCoefficient;
                              break;
            case "monthly"  : periodicCoefficient = 12;
                              period = years * periodicCoefficient;   
                              break;
            case "daily"    : periodicCoefficient = 365;
                              period = years * periodicCoefficient;
                              break;
                     default: System.out.println("Incorrect input");                  
        }
        
        BigDecimal[] balanceArray = new BigDecimal[period];
        
        System.out.println("Initial amount of principal,$: ");
        String beginningBalanceString = myScanner.nextLine();
        BigDecimal beginningBalanceBeforeScale = new BigDecimal(beginningBalanceString);
        BigDecimal beginningBalanceScale = beginningBalanceBeforeScale.setScale(2, RoundingMode.HALF_UP);
        // Calculate the balances of the investment
        BigDecimal op1 = new BigDecimal("1");
        String periodicCoefficientString = Integer.toString(periodicCoefficient);
        BigDecimal periodicCoefficientBD = new BigDecimal(periodicCoefficientString);
        BigDecimal periodicCoefficientScale = periodicCoefficientBD.setScale(2, RoundingMode.HALF_UP);
        BigDecimal op100 = new BigDecimal("100");
        for(int i = 0; i < period; i++){
            if(i == 0){
                balanceArray[i] = beginningBalanceScale.multiply(op1.add((annualInterestRateScale.divide(periodicCoefficientScale, 2, RoundingMode.HALF_UP)).divide(op100, 2, RoundingMode.HALF_UP)));
            } else {
                balanceArray[i] = balanceArray[i - 1].multiply(op1.add((annualInterestRateScale.divide(periodicCoefficientScale, 2, RoundingMode.HALF_UP)).divide(op100, 2, RoundingMode.HALF_UP)));
            }
        }
        // Display a table for the balances
        displayTable(beginningBalanceScale, period, periodicCoefficient, balanceArray);
    }
    
    
    /*
     * Mehtod to display yearly table of balances and interests   
    */
    public static void displayTable(BigDecimal beginningBalance, int period, int periodicCoefficient, BigDecimal balanceArray[]){
        for(int i = 0; i < period; i++ ){
            if((i + 1) % periodicCoefficient == 0 && (i + 1) / periodicCoefficient == 1){
            System.out.printf("\nYear           : %10d ", (i + 1) / periodicCoefficient);
            } else if ((i + 1) % periodicCoefficient == 0){
            System.out.printf("%10d ", (i + 1) / periodicCoefficient);
            }
        }
        System.out.println();
        for(int i = 0; i < period; i++ ){
            if((i + 1) % periodicCoefficient == 0 && (i + 1) / periodicCoefficient == 1){
            System.out.print("Beg. principal : " + beginningBalance.toString());
            } else if ((i + 1) % periodicCoefficient == 0){
            System.out.print(balanceArray[i - periodicCoefficient].toString());
            }
        }
        System.out.println();
        for(int i = 0; i < period; i++ ){
            if((i + 1) % periodicCoefficient == 0 && (i + 1) / periodicCoefficient == 1){
            System.out.print("Interest earned: " + (balanceArray[i].subtract(beginningBalance)).toString());
            } else if ((i + 1) % periodicCoefficient == 0){
            System.out.print((balanceArray[i].subtract(balanceArray[i - periodicCoefficient])).toString());
            }
        }
        System.out.println();
        for(int i = 0; i < period; i++ ){
            if((i + 1) % periodicCoefficient == 0 && (i + 1) / periodicCoefficient == 1){
            System.out.print("End. principal : " + balanceArray[i].toString());
            } else if ((i + 1) % periodicCoefficient == 0){
            System.out.print(balanceArray[i].toString());
            }
        }
        System.out.println();
    }
}
