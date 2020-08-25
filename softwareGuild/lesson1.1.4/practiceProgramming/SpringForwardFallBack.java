package com.sg.springforwardfallback;

public class SpringForwardFallBack {
    public static void main(String[] args){
        System.out.println("It's Spring...!");
        // Start range - 0, and stop range - 9
        for(int i = 1; i <= 10; i++){
            System.out.print(i + ", ");
        }
        // Start range - 10, and stop range - 1
        System.out.println("\nOh no, it's fall...");
        for(int i = 10; i > 0; i--){
            System.out.print(i + ", ");
        }
    }
}
