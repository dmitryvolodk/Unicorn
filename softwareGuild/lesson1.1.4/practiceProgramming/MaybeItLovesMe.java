package com.sg.maybeitlovesme;

import java.util.Random;

public class MaybeItLovesMe {
    public static void main(String[] args){
        Random randomizer = new Random();
        int counter = 0; // Initialize petals number
        String petalLovesMe = "It loves me!", 
               petalLovesMeNOT = "It LOVES me NOT!",
               latestPetal = "";
        
        counter = randomizer.nextInt(77) + 13;
        
        System.out.println("Well here goes nothing..." + "Size: " + counter);
        
        while(counter > 0){
            System.out.println(petalLovesMe);
            counter--;
            latestPetal = petalLovesMe;
            if(counter > 0){
                System.out.println(petalLovesMeNOT);
                counter--;
                latestPetal = petalLovesMeNOT;
            }
        }
        
        if(latestPetal.equals("It LOVES me NOT!")){
            System.out.println("Awwww, bummer.");
        } else {
            System.out.println("Oh, wow! It really LOVES me!");
        }
    }
}
