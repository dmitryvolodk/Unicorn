package com.sg.knockknock;

import java.util.Scanner;

public class KnockKnock {
    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();
        
        // If you change "equals" to "==" then strings will not be compared by the values. "==" checks if the objects point to the same memory location
        if(nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); // Sorry, had to!
        } else {
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}
