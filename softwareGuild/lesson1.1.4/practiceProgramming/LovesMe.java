package com.sg.lovesme;

public class LovesMe {
    public static void main(String[] args){
        int counter = 34;
        
        System.out.println("Well here goes nothing...");
        
        while(counter > 0){
            System.out.println("It loves me NOT!");
            counter--;
            if((counter % 2 != 0) && counter > 0){
                System.out.println("It LOVES me!");
                counter--;
            }
        }
        
        System.out.println("I knew it! It LOVES ME!");
    }
}
