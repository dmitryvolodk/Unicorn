package com.sg.forandtwentyblackbirds;

import java.util.*;

public class ForAndTwentyBlackbirds {
    public static void main(String[] args){
        int birdsInPie = 0;
        for(int i = 1; i < 21; i++){
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }
        
        System.out.println("Ther are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
    }
}
