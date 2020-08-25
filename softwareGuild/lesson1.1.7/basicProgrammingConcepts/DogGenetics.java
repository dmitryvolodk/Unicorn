/*
* Program name: Dog Genetics
* Author: Dmitry Volodkevich
* Date created: 8/6/2020
* Date revised:
*/

package com.sg.doggenetics;

import java.util.Scanner;
import java.util.Random;

public class DogGenetics {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        Random randomizer = new Random();
        // Creat an array to hold percentages of the breed
        int[] breedsPercentage = new int[5];
        // Initialize an array to hold breeds' names
        String[] breedsNames = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
        // Prompt the user for the dog's name
        System.out.println("What is your dog's name?");
        String dogName = myScanner.nextLine();
        // Assign the percentages of the breeds
        breedsPercentage[4] = 100;
        int portion = 100;
        for(int i = 0; i < 4; i++){
            breedsPercentage[i] = randomizer.nextInt(portion) + 1;
            if((portion - breedsPercentage[i]) >= 0){
                portion -= breedsPercentage[i];
            } else {
                portion = 0;
            }
            breedsPercentage[4] -= breedsPercentage[i];
        }
            
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.\n");
        System.out.println(dogName + " is:\n");
        // Display the percentages of the breeds    
        for(int j = 0; j < breedsNames.length; j++){
        System.out.println(breedsPercentage[j] + "% " + breedsNames[j]);
        }
            
        System.out.println("\nWow, that's QUITE the dog!");
    }
}
 