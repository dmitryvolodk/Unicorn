package com.sg.birthstones;

import java.util.Scanner;

public class BirthStones {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int chosenNumber;
        String chosenNumberString;
        int monthNumber;
        
        System.out.println("What month's birthstone are you wanting to know? ");
        chosenNumberString = myScanner.nextLine();
        chosenNumber = Integer.parseInt(chosenNumberString);
        
        if(chosenNumber == 1){
            System.out.println("January's birthstone is Garnet");
        } else if (chosenNumber == 2){
            System.out.println("February's birthstone is Amethyst");
        } else if (chosenNumber == 3){
            System.out.println("March's birthstone is Aquamarine");
        } else if (chosenNumber == 4){
            System.out.println("April's birthstone is Diamond");
        } else if (chosenNumber == 5){
            System.out.println("May's birthstone is Emerald");
        } else if (chosenNumber == 6){
            System.out.println("June's birthstone is Pearl");
        } else if (chosenNumber == 7){
            System.out.println("July's birthstone is Ruby");
        } else if (chosenNumber == 8){
            System.out.println("August's birthstone is Peridot");
        } else if (chosenNumber == 9){
            System.out.println("September's birthstone is Sapphire");
        } else if (chosenNumber == 10){
            System.out.println("October's birthstone is Opal");
        } else if (chosenNumber == 11){
            System.out.println("November's birthstone is Topaz");
        } else if (chosenNumber == 12){
            System.out.println("December's birthstone is Turquoise");
        } else {
            System.out.println("I think you must be confused, " + chosenNumber + " doesn't match a month.");
        }
    }
}    