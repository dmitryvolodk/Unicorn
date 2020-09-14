package com.sg.yourlifeinmovies;

import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int age;
        String ageString;
        String name;
        
        System.out.println("Hey, lets play a game! What's your name? ");
        name = myScanner.nextLine();
        
        System.out.println("Ok, " + name + ", when were you born?");
        ageString = myScanner.nextLine();
        age = Integer.parseInt(ageString);
        
        System.out.println("Well " + name + "...");
     
        if(age <= 2005){
            System.out.println("Did you know that Pixar's 'Up' came out half a decade ago? ");
            if(age <= 1995){
                System.out.println("And that the first Harry Potter came out over 15 years ago! ");
                if(age <= 1985){
                    System.out.println("Also, Space Jam came out not last decade, but the one before THAT. ");
                    if(age <= 1975){
                        System.out.println("The original Jurassic Park release is closer to the date of the first lunar landing than it is to today. ");
                        if(age <= 1965){
                            System.out.println("The MASH TV series has been around for almost half a century! ");
                        }
                    }
                }
            }
        } else {
            System.out.println("You are too young. Ask your parents for permission to play the game. ;) ");
        }
    }
}
