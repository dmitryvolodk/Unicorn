package com.sg.birthdaycalculatordatetimeapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BirthDAYCalculator {
    public void calculateBirthday(String birthDay){
        // Specify the pattern of the incoming date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        // Create a LocalDate object containing birthday
        LocalDate ldBirthday = LocalDate.parse(birthDay, formatter);
        
        // Get and display the day of week
        DayOfWeek dayOfWeek = ldBirthday.getDayOfWeek();
        System.out.println("That's means you were born on " + dayOfWeek + "!");
        
        // Get today's day and extract the current year
        LocalDate ldToday = LocalDate.now();
        
        // Get current year
        int currentYear = ldToday.getYear();
        
        // Get birthday year
        int birthdayYear = ldBirthday.getYear();
        
        // Calculate how many years passed since birthday
        int yearsPassed = currentYear - birthdayYear;
        
        // Calculate current year birthday
        LocalDate CYBirthday = ldBirthday.plusYears(yearsPassed);
        
        // Get and display the day of week of current birthday year
        DayOfWeek CYBirthdayWeekDay = CYBirthday.getDayOfWeek();
        System.out.println("This year it falls on " + CYBirthdayWeekDay + "...");
        
        
        // Calculate the number of days until the next birthday
        long birthdaysDiff = ChronoUnit.DAYS.between(ldToday, CYBirthday);

        LocalDate nextYearBirthday;
        LocalDate nextBirthdayDate = CYBirthday;
        
        // Use next year birthday if current year birthday already passed
        if(birthdaysDiff < 0){
            nextYearBirthday = CYBirthday.plusYears(1);
            nextBirthdayDate = nextYearBirthday;
            birthdaysDiff = ChronoUnit.DAYS.between(ldToday, nextYearBirthday);
        }
        
        // Formatt todays date as MM/dd/yyyy
        String formattedLdToday = ldToday.format(formatter);
        
        // Display how many days are untill the next birthday
        System.out.println("And since today is  " + formattedLdToday + " there's only " 
                + birthdaysDiff + " more days until the next one!");
        
        // Calculate how many years old they will be
        long yearsOldNextBirthday = ChronoUnit.YEARS.between(ldBirthday, nextBirthdayDate);
        
        System.out.println("Bet yer excited to be turning " + yearsOldNextBirthday + "!");
    }
}
