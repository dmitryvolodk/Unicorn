package com.sg.morebucketsmorefun;

public class MoreBucketsMoreFun {
    public static void main(String[] args){
        // Declare ALL THE THINGS
        // (Usually it's a good idea to declare them at the beginning of the program)
        int butterflies, beetles, bugs;
        String color, size, shape, things;
        double number;
        
        // Now give a couple of them some values
        butterflies = 2;
        beetles = 4;
        
        bugs = butterflies + beetles;
        System.out.println("There are only " + butterflies + " butterflies,");
        System.out.println("but " + bugs + " bugs total.");
        
        System.out.println("Uh oh, my dogate one.");
        // This unary operator we used to show that the dog ate the bug
        butterflies--;
        System.out.println("Now there are only " + butterflies + " butterflies left.");
        // The number of bugs is not changed here because it calculated before a butterfly was substracted
        System.out.println("But still " + bugs + " bugs left, wait a minute!!!");
        System.out.println("Maybe I just counted wrong the first time...");
    }
}
