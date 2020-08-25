package com.sg.biggerbetteradder;

import java.util.Scanner;

public class BiggerBetterAdder {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        int sum;
        
        int number1;
        int number2;
        int number3;
        
        System.out.println("Please enter number1: ");
        number1 = myScanner.nextInt();
        
        System.out.println("Please enter number2: ");
        number2 = myScanner.nextInt();
        
        System.out.println("Please enter number3: ");
        number3 = myScanner.nextInt();
        
        System.out.println("Number1 = " + number1);
        System.out.println("Number2 = " + number2);
        System.out.println("Number3 = " + number3);
        
        sum = number1 + number2 + number3;
        
        System.out.println("Sum = " + sum);
        System.out.println("Sum = " + sum);
    }
}
