package com.sg.passingtheturingtest;

import java.util.Scanner;

public class PassingTheTuringTest {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        String yourName, yourColor, yourFruit;
        int yourNumber;
        
        String myName = "Dmitry", myColor = "Electric Lime";
        int myNumber = 7;
        
        System.out.println("Hello there!");
        
        System.out.print("What's your name? ");
        yourName = myScanner.next();
        
        System.out.println("Hi, " + yourName + "! What's your favorite color? ");
        yourColor = myScanner.nextLine();
        
        System.out.println("Huh, " + yourColor + "? Mine's " + myColor + ".");
        
        System.out.println("I really like limes. They're my favorite fruit, too.");
        System.out.println("What's YOUR favorite fruit, " + yourName + "?");
        yourFruit = myScanner.nextLine();
        
        System.out.println("Really? " + yourFruit + "? " + "That's wild!");
        System.out.println("Speaking of favorites, what's your favorite number? ");
        yourNumber = myScanner.nextInt();
        
        System.out.println(yourNumber + " is a cool number. Mine's " + myNumber + ".");
        System.out.println("Did you know 42 * " + myNumber + " is " + (42 * 7) + "? That's a cool number too!");
        
        System.out.println("Well, thanks for talking to me, " + yourName + "!");
    }
}
