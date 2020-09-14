package com.sg.waitawhile;

public class WaitAWhile {
    public static void main(String[] args){
        int timeNow = 5;
        int bedTime = 10;
        
        // If we chane timeNow to 11 then timeNow is greater than bedTime and while loop will not be entered 
        while(timeNow < bedTime){
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiitle longer....");
            // If we comment out timeNow++ then while loop will be infinit
            timeNow++; //Time passes
        }
        
        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
}
