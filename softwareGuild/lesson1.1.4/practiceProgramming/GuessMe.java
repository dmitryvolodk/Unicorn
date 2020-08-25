package com.sg.guessme;

import java.util.Scanner;
import java.util.Random;

public class GuessMe {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();
        
        int randomNumber;
        int guessNumber;
        String guessNumberString;
        
        randomNumber = randomGenerator.nextInt(10) + 1;
        
        System.out.println("Pick a number: ");
        guessNumberString = myScanner.nextLine();
        guessNumber = Integer.parseInt(guessNumberString);
        
        if(guessNumber == randomNumber){
            System.out.println("Wow, nice guess! That was it!");
        } else if(guessNumber < randomNumber){
            System.out.println("Ha, nice try - too low! I chose #" + randomNumber);
        } else
            System.out.println("Too bad, way too high. I chose #" + randomNumber);
        
    }
}
