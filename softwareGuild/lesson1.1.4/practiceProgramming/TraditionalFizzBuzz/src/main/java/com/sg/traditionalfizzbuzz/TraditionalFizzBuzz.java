package com.sg.traditionalfizzbuzz;

import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int userNumber = 0,
                counter = 0;
        
        System.out.println("How much units fizzing and buzzing do you need in your life? ");
        userNumber = myScanner.nextInt();
        System.out.println();
        
        for(int i = 0; i < 10000; i++){
            if((i % 3 == 0) && (i != 0) && (i % 5 != 0)){
                System.out.println("fizz");
                counter++;
            } else if ((i % 5 == 0) && (i != 0) && (i % 3 != 0)){
                System.out.println("buzz");
                counter++;
            } else if ((i % 3 == 0) && (i % 5 == 0) && (i != 0) ){
                System.out.println("fizz buzz");
                counter++;
            } else {
                System.out.println(i);
            }
            if(counter == userNumber){
                System.out.println("TRADITION!!!!!");
                break;
            }
        }
    }
}
