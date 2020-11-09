package com.sg.enumshowmanydaysuntilfriday;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DaysCalculator calculator = new DaysCalculator();
        int daysNumber = 0;
        
        System.out.println("Please enter a day of the week, e.g. MONDAY: ");
        Scanner myScanner = new Scanner(System.in);
        
        WeekDay day = WeekDay.valueOf(myScanner.nextLine());
        
        daysNumber = calculator.calculateDays(day);
        
        System.out.println("Number of days before Friday: " + daysNumber);
        
    }

}
