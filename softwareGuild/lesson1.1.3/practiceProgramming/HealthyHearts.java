package com.sg.healthyhearts;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args){
        float age;
        String stringAge;
        float maxRate;
        float targetHeartLower, targetHeartUpper;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("What is your age ? ");
        stringAge = myScanner.nextLine();
        age = Float.parseFloat(stringAge);
        
        maxRate = 220f - age;
        targetHeartLower = maxRate * 0.50f;
        targetHeartUpper = maxRate * 0.85f;
        
        System.out.println("Your maximum heart rate should be " + maxRate);
        System.out.println("Your target HR Zone is " + targetHeartLower + " - " + targetHeartUpper +
                " beats per minute");
    }
}
