package com.sg.interestcalculator;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int period = 0,
                years = 0,
                quarters = 0,
                months = 0,
                days = 0,
                periodicCoefficient = 0;
        
        float annualInterestRate = 0f;
        
        String yearsString = "",
                annualInterestRateString = "";
        
        System.out.println("We will calculate the investment.\n");
        // Ask the user for the input
        System.out.println("The number of years the money is to stay in the fund,#: ");
        yearsString = myScanner.nextLine();
        years = Integer.parseInt(yearsString);
        
        System.out.println("Annual interest rate,%: ");
        annualInterestRateString = myScanner.nextLine();
        annualInterestRate = Float.parseFloat(annualInterestRateString);
        
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
        
        float[] balanceArray = new float[period];
        
        System.out.println("Initial amount of principal,$: ");
        float beginningBalance = myScanner.nextFloat();
        // Calculate the balances of the investment
        for(int i = 0; i < period; i++){
            if(i == 0){
                balanceArray[i] = beginningBalance * (1 + ((annualInterestRate / (float)periodicCoefficient) / 100));
            } else {
                balanceArray[i] = balanceArray[i - 1] * (1 + ((annualInterestRate / (float)periodicCoefficient) / 100));
            }
        }
        // Display a table for the balances
        displayTable(beginningBalance, period, periodicCoefficient, balanceArray);
    }
    
    /*
     * Mehtod to display yearly table of balances and interests   
    */
    public static void displayTable(float beginningBalance, int period, int periodicCoefficient, float balanceArray[]){
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
            System.out.printf("Beg. principal : %,10.0f ", beginningBalance);
            } else if ((i + 1) % periodicCoefficient == 0){
            System.out.printf("%,10.0f ", balanceArray[i - periodicCoefficient]);
            }
        }
        System.out.println();
        for(int i = 0; i < period; i++ ){
            if((i + 1) % periodicCoefficient == 0 && (i + 1) / periodicCoefficient == 1){
            System.out.printf("Interest earned: %,10.0f ", (balanceArray[i] - beginningBalance));
            } else if ((i + 1) % periodicCoefficient == 0){
            System.out.printf("%,10.0f ", (balanceArray[i] - balanceArray[i - periodicCoefficient]));
            }
        }
        System.out.println();
        for(int i = 0; i < period; i++ ){
            if((i + 1) % periodicCoefficient == 0 && (i + 1) / periodicCoefficient == 1){
            System.out.printf("End. principal : %,10.0f ", balanceArray[i]);
            } else if ((i + 1) % periodicCoefficient == 0){
            System.out.printf("%,10.0f ", balanceArray[i]);
            }
        }
        System.out.println();
    }
}
