package com.sg.doitbetter;

import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int milesCanRun, hotdogsToEat, languages;
        
        System.out.println("For how many mile can you run? ");
        milesCanRun = myScanner.nextInt();
        
        System.out.println("How many hotdogs can you it? ");
        hotdogsToEat = myScanner.nextInt();
        
        System.out.println("How many languages do you know? ");
        languages = myScanner.nextInt();
        
        System.out.println("I can do more! ");
        System.out.println("I can run " + (milesCanRun * 2 + 1));
        System.out.println("I can eat " + (hotdogsToEat * 2 + 1));
        System.out.println("I can speak " + (languages * 2 + 1));
    }
}
