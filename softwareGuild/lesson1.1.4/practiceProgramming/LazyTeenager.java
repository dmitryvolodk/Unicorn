package com.sg.lazyteenager;

import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args){
        Random randomizer = new Random();
        
        float probability = 0f;
        int decision = 0;
        int counter = 0;
        int percentNumber = 5;
        
        
        do{
            counter++;
            System.out.println("Clean your room!! (x" + counter + ")");
            
            if(counter == 15){
                break;
            }
            
            System.out.println("Probability: " + percentNumber + "%");
            
            decision = randomizer.nextInt(100/percentNumber) + 1;
            percentNumber = percentNumber + 5;
        }while(decision != 1);
        
        if(decision == 1){
            System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
        } else {
            System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
        }
    }
}
