package com.sg.guessmefinally;

import java.util.Scanner;
import java.util.Random;

public class GuessMeFinally {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();
        
        int randomNumber;
        int guessNumber;
        String guessNumberString;
        
        randomNumber = randomGenerator.nextInt(201) - 100;
        
        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it!");
        System.out.println("Your guess" + randomNumber + ": ");
        guessNumberString = myScanner.nextLine();
        guessNumber = Integer.parseInt(guessNumberString);
        
        if(guessNumber == randomNumber){
            System.out.println("\nWow, nice guess! That was it!");
            
        } else if(guessNumber < randomNumber){
            System.out.println("\nHa, nice try - too low! Try again!");
            
            while(guessNumber != randomNumber){
                System.out.println("Your guess: ");
                guessNumberString = myScanner.nextLine();
                guessNumber = Integer.parseInt(guessNumberString);
                if(guessNumber == randomNumber){
                    System.out.println("\nFinally! It's about time you got it!");
                } else if(guessNumber < randomNumber){
                    System.out.println("\nHa, nice try - too low! Try again!");
                } else {
                 System.out.println("\nToo bad, way too high.  Try again!");
                }
            }
            
        } else {
            System.out.println("\nToo bad, way too high. Try again!");
            
            while(guessNumber != randomNumber){
                System.out.println("Your guess: ");
                guessNumberString = myScanner.nextLine();
                guessNumber = Integer.parseInt(guessNumberString);
                if(guessNumber == randomNumber){
                    System.out.println("\nFinally! It's about time you got it!");
                } else if(guessNumber < randomNumber){
                    System.out.println("\nHa, nice try - too low!  Try again!");
                } else {
                    System.out.println("\nToo bad, way too high. Try again!");
                }
            }
        }
    }
}
