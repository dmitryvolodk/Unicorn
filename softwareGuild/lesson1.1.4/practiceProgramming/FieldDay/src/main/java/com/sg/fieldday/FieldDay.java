package com.sg.fieldday;

import java.util.Scanner;

public class FieldDay {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        String yourName = "";
        
        System.out.println("What's your last name? ");
        yourName = myScanner.nextLine();
        
        if(yourName.compareTo("Baggins") <= 0){
            System.out.println("Aha! You're on the team \"Red Dragons\"!");
        } else if (yourName.compareTo("Dresden") <= 0) {
            System.out.println("Aha! You're on the team \"Dark Wizards\"!");
        } else if (yourName.compareTo("Howl") <= 0) {
            System.out.println("Aha! You're on the team \"Moving Castles\"!");
        } else if (yourName.compareTo("Potter") <= 0) {
            System.out.println("Aha! You're on the team \"Golden Snitches\"!");
        } else if (yourName.compareTo("Vimes") <= 0) {
            System.out.println("Aha! You're on the team \"Night Guards\"!");
        } else {
            System.out.println("Aha! You're on the team \"Black Holes\"!");
        }
    }
}
