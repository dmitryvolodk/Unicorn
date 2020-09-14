package com.sg.doordonot;

import java.util.Scanner;

public class DoOrDoNot {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Should I do it? (y/n) ");
        boolean doIt;
        
        if(input.next().equals("y")){
            doIt = true; // DO IT!
        } else {
            doIt = false; // DON'T YOU DARE!
        }
        
        boolean iDidIt = false;
        
        // iDidIt is true anyway because do...while excecutes at least once
        /*
        do{
            iDidIt = true;
            break;
        }while(doIt);
        */
        
        // "n" answer skeeps the loop and doesn't assign true to iDidIt. The loop is no excecuted.
        while(doIt){
            iDidIt = true;
            break;
        }

        if(doIt && iDidIt){
            System.out.println("I did it!");
        } else if(!doIt && iDidIt){
            // It happens if answer is "n" and do...while loop only
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            // It happens only if answer "n" and while loop only
            System.out.println("Don't look at me, I didn't do anything!");
        }
    }
}
