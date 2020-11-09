package com.sg.birthdaycalculatordatetimeapi;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        BirthDAYCalculator calculator = new BirthDAYCalculator();
        System.out.println("What's your birthday? e.g. 01/01/2002");
        
        String birthday = myScanner.nextLine();
        
        // Calculate and display birthday info
        calculator.calculateBirthday(birthday);
        
    }
}
