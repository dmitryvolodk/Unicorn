package com.sg.minimadlibs;

import java.util.Scanner;

public class MiniMadLibs {
    public static void main(String[] args){
        String noun1, adjective2, noun3, number, adjective5, pluralNoun6, pluralNoun7, pluralNoun8, verbPresentTense, verbPastTense;
        
    Scanner myScanner = new Scanner(System.in);
    
    
    System.out.println("I need a noun: ");
    noun1 = myScanner.nextLine();
    
    System.out.println("Now an adj: ");
    adjective2 = myScanner.nextLine();
    
    System.out.println("Another noun: ");
    noun3 = myScanner.nextLine();
    
    System.out.println("And a number: ");
    number = myScanner.nextLine();
    
    System.out.println("Another adj: ");
    adjective5 = myScanner.nextLine();
    
    System.out.println("A plural noun: ");
    pluralNoun6 = myScanner.nextLine();
    
    System.out.println("Another one: ");
    pluralNoun7 = myScanner.nextLine();
    
    System.out.println("One more: ");
    pluralNoun8 = myScanner.nextLine();
    
    System.out.println("A verb (present tense): ");
    verbPresentTense = myScanner.nextLine();
    
    System.out.println("A verb (past tense): ");
    verbPastTense = myScanner.nextLine();
    
    System.out.println("*** NOW LETS GET MAD (libs) ***");
    System.out.println(noun1 + " : the " + adjective2 + " frontier. These are the voyages of the starship " +
            noun3 + ". Its " + number + "-year mission: to explore strange " + adjective5 + " " +
            pluralNoun6 + ", to seek out " + adjective5 + " " + pluralNoun7 + " and " + adjective5 +
            " " + pluralNoun8 + ", to boldly " + verbPresentTense + " where no one has " + verbPastTense + " before.");
    }
    
}
