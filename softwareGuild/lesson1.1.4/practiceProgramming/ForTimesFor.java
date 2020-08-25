package com.sg.fortimesfor;

import java.util.Scanner;

public class ForTimesFor {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int userNumber = 0;
        String userNumberString = "";
        int userAnswer = 0;
        int points = 0;
        
        System.out.println("Which times table shall I recite? ");
        userNumberString = myScanner.nextLine();
        userNumber = Integer.parseInt(userNumberString);
        
        for(int i = 1; i <= 15; i++){
            System.out.println(i + " * " + userNumber + " is: ");
            userAnswer = myScanner.nextInt();
            
            if(userAnswer == (i * userNumber)){
                System.out.println("Correct!");
                points++;
            } else {
                System.out.println("Sorry no, the answer" +  " is: " + (i * userNumber));
            }
            
        }
        System.out.println("You got " + points + " correct.");
        
        if(points < (15 / 2)){
            System.out.println("You should study more, because you got less than 50% correct.");
        }
        if(points >= ((15 * 90) / 100)){
            System.out.println("Congratulations! You got over 90% correct!");
        }
    }
}
