package com.sg.luckysevens;

import java.util.Scanner;
import java.util.Random;

public class LuckySevens {
    public static void main(String[] args){
        Random randomizer = new Random();
        Scanner myScanner = new Scanner(System.in);
        
        int diceOne = 0,
                diceTwo = 0,
                rollsTaken = 0,
                maxMoney = 0,
                rollsMaxMoney = 0;
        
        System.out.println("How many dollars do you have? ");
        int dollars = myScanner.nextInt();
        
        maxMoney = dollars;
        
        while(dollars != 0){
            diceOne = randomizer.nextInt(6) + 1;
            diceTwo = randomizer.nextInt(6) + 1;
            System.out.println(diceOne + " " + diceTwo);
            if((diceOne + diceTwo) == 7){
                dollars += 4;
            } else {
                dollars -= 1;
            }
            rollsTaken++;
            
            if(maxMoney < dollars){
                maxMoney = dollars;
                rollsMaxMoney = rollsTaken;
            }
        }
        
        System.out.println("You are broke after " + rollsTaken);
        System.out.println("You should have quit after " + rollsMaxMoney + " rolls when you had $" + maxMoney);
    }
}
