package com.sg.staypositive;

import java.util.Scanner;

public class StayPositive {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int userNumber;
        String userNumberString;
        
        System.out.println("What number should I count down from? ");
        userNumberString = myScanner.nextLine();
        userNumber = Integer.parseInt(userNumberString);
        
        System.out.println("\nHere goes! \n");
        
        while(userNumber >= 0){
            int lineCounter = 0;
            while(userNumber >= 0 && lineCounter < 10){
            System.out.print(userNumber + " ");
            userNumber--;
            lineCounter++;
            }
            System.out.println();
        }
        
        System.out.println("\nWhew, better stop there...!");
    }
}
