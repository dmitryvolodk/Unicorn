package com.sg.highroller;

import java.util.Random;
import java.util.Scanner;

public class HighRoller {
    public static void main(String[] args){
        Random diceRoller = new Random();
        Scanner myScanner = new Scanner(System.in);
        
        int sidesNumber = 0;
        String sidesNumberString = "";
        
        System.out.println("What is the number of sides the dice has? ");
        sidesNumberString = myScanner.nextLine();
        sidesNumber = Integer.parseInt(sidesNumberString);
        
        int rollResult = diceRoller.nextInt(sidesNumber) + 1;
        
        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);
        
        if(rollResult == 1){
            System.out.println("You rolled a critical failure!");
        }
        
        if(rollResult == sidesNumber){
            System.out.println("You rolled a critical! Nice Job!");
        }
    }
}
