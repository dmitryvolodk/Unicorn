package com.sg.coinflipper;

import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args){
        Random coinGenerator = new Random();
        
        boolean coinSide = true;
        
        System.out.println("Ready, Set, Flip....!! ");
        coinSide = coinGenerator.nextBoolean();
        
        if(coinSide == true){
            System.out.print("You got TAILS!");
        } else {
            System.out.print("You got HEADS!");
        }
    }
}
