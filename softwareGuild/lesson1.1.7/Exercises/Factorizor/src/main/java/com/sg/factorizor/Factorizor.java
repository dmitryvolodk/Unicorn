/*
Program: Factorizor - Java Console Application
Author: Dmitry Volodkevich
Date created: 08/01/2020
*/

package com.sg.factorizor;

import java.util.Scanner;

public class Factorizor {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        // Declare and initialize variables
        int number = 0,         // the number to be factorized
            factorCounter = 0,  // the counter of the factors
            perfectCheck = 0;   // the variable to perform a "perfect" check of the number
        // ask the user the number for which he/she wants to factor
        System.out.println("What number would you like to factor? ");
        number = myScanner.nextInt();
        // print out the original number
        System.out.println("\nThe factors of " + number + " are:");
        // print out each factor of the number (not including the number itself)
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                // print factors except the number itself
                if(i != number){
                System.out.println(i);
                perfectCheck += i;
                }
                factorCounter++;
            }
        }
        // print out whether or not the number is perfect
        if(number == perfectCheck){
            System.out.println("\n" + number + " is a perfect number.");
        } else {
            System.out.println("\n" + number + " is not a perfect number.");
        }
        // print ou whether or not the number is prime
        if(factorCounter == 2){
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
        // print out the the total number of factors for the number
        System.out.println("\nTotal number of factors: " + factorCounter);
    }
}
