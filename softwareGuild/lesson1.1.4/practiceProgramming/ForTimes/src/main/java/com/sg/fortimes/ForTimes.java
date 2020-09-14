package com.sg.fortimes;

import java.util.Scanner;

public class ForTimes {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int userNumber = 0;
        String userNumberString = "";
        
        System.out.println("Which times table shall I recite? ");
        userNumberString = myScanner.nextLine();
        userNumber = Integer.parseInt(userNumberString);
        
        for(int i = 1; i <= 15; i++){
            System.out.println(i + " * " + userNumber + " is: " + (i * userNumber));
        }
    }
}
