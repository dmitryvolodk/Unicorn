package com.sg.allthetrivia;

import java.util.Scanner;

public class AllTheTrivia {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        String terabyteAnswer, clockwisePlanet, largestVolcanoPlanet, abundantElement;
        
        System.out.println("1,024 Gigabytes is equal to one what? ");
        terabyteAnswer = myScanner.nextLine();
        
        System.out.println("In our solar system which is the only planet that rotates clockwise");
        clockwisePlanet = myScanner.nextLine();
        
        System.out.println("The largest volcano ever discovered in our solar system is located on which planet? ");
        largestVolcanoPlanet = myScanner.nextLine();
        
        System.out.println("What is the most abundant element in the earth's atmosphere? ");
        abundantElement = myScanner.nextLine();
        
        System.out.println();
        
        System.out.println("Wow, 1,024 Gigabytes is a " + largestVolcanoPlanet + "!");
        System.out.println("I didn't know that the largest ever volcano was discovered on " + terabyteAnswer);
        
        System.out.println("That's amazing that " + clockwisePlanet + " is the most abundant element in the atmosphere...");
        System.out.println(abundantElement + " is the only planet that rotates clockwise, neat!");
    }
}
