package com.sg.thecount;

import java.util.Scanner;

public class TheCount {
    public static void main(String[] args){
    Scanner myScanner = new Scanner(System.in);
    
    int start = 0,
            stop = 0,
            count = 0,
            nextLine = 0;
    String startString = "",
            stopString = "",
            countString = "";

    
    System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
    
    System.out.println("Start at: ");
    start = myScanner.nextInt();
    //start = Integer.parseInt(startString);
    
    System.out.println("Stop at: ");
    stop = myScanner.nextInt();
    //stop = Integer.parseInt(startString);
    
    System.out.println("Count by: ");
    count = myScanner.nextInt();
    //count = Integer.parseInt(startString);
    
    System.out.println();
    
    for(int i = start; i <= stop; i = i + count){
        System.out.print(i + " ");
        nextLine++;
        if(nextLine % 3 == 0){
            System.out.println("- Ah ah ah!");
        }
    }
    }
}
