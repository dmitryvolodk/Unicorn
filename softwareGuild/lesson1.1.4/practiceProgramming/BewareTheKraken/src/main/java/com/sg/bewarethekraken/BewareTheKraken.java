package com.sg.bewarethekraken;

import java.util.Scanner;
import java.util.Random;

public class BewareTheKraken {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        Random randomizer = new Random();
        
        System.out.println("Already, get those flippres and wetsuit on - we're going fiving!");
        System.out.println("Here we goooOOooOooo......! *SPLASH*");
        
        int depthDivedInFt = 0;
        String userInput = "";
        int randomFish = 0;
        
        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        // If we turn the while loop's condition to just "true" - it will be an infinit loop and never will stop.
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");
            
            randomFish = randomizer.nextInt(3);
            switch(randomFish){
                case 0: System.out.println("Wait a second! I see a shark! Everyone stays steel!!!");
                        break;
                case 1: System.out.println("Wow! Look guys, we have our friends dolphins behind us!");
                        break;
                case 2: System.out.println("Wait, wait!! It's impressive! Whales!");
            }
            
            System.out.println("Would you like to stop? (y/n)");
            userInput = myScanner.nextLine();
            if(userInput.equals("y")){
                System.out.println("Hey guys, I am getting tired ....");
                System.out.println("TIME TO SURFACE!");
                break;
            }
                    
            if(depthDivedInFt >= 20000){
                System.out.println("Uhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }
            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down");
        System.out.println("I bet we can do better next time!");
    }
}
