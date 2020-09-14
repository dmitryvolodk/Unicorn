package com.sg.trivianight;

import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int counter = 0;
        int yourAnswer;
        String yourAnswerString;
        
        System.out.println("It's TRIVIA NIGHT! Are you ready?! \n");
        
        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code             2) Assembly Language \n" +
                           "3) C#                      4) Machine Code \n");
        
        System.out.println("YOUR ANSWER: ");
        yourAnswerString = myScanner.nextLine();
        yourAnswer = Integer.parseInt(yourAnswerString);
        
        if(yourAnswer == 4){
            counter++;
        }
        
        System.out.println("\nSECOND QUESTION!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper            2) Alan Turing \n" +
                           "3) Charles Babbage         4) Larry Page \n");
                
        System.out.println("YOUR ANSWER: ");
        yourAnswerString = myScanner.nextLine();
        yourAnswer = Integer.parseInt(yourAnswerString);
        
        if(yourAnswer == 2){
            counter++;
        }
        
        System.out.println("\nLAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity                2) The Battlestar Galactica \n" +
                           "3) The USS Enterprise      4) The Millennium Falcon \n");
        
        System.out.println("YOUR ANSWER: ");
        yourAnswerString = myScanner.nextLine();
        yourAnswer = Integer.parseInt(yourAnswerString);
        
        if(yourAnswer == 3){
            counter++;
        }
        
        if(counter == 3){
            System.out.println("\nGreat - you got ALL 3 correct! ");
        } else if (counter >= 1) {
            System.out.println("\nNice job - you got " + counter + " correct! ");
        } else {
            System.out.println("\nNon of the answers are correct. Your luck will come later! ");
        }
    }
}
