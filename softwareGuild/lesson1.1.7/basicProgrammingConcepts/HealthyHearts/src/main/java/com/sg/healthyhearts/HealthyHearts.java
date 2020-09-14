/*
* Program name: Healthy Hearts
* Author: Dmitry Volodkevich
* Date created: 08/06/2020
* Date revised:
*/

package com.sg.healthyhearts;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        // Declare and initialize the variabls to hold the target heart rate zone percentages
        float lowerZonePercent = 50;
        float upperZonePercent = 85;
        // Prompt the user for the age
        System.out.println("What is your age?");
        int age = myScanner.nextInt();
        // Calculate the maximum heart rate
        int maxRate = 220 - age;
        // Display the maximum heart rate and the target heart rate zone        
        System.out.println("Your maximum heart rate should be " + maxRate + " beats per minute");
        System.out.println("Your target HR Zone is " + Math.round((float)lowerZonePercent * (float)maxRate / 100f) 
                + " - " + Math.round((float)upperZonePercent * (float)maxRate / 100f) + " beats per minute");
    }
}
