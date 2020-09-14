package com.sg.differentkettleoffish;

public class DifferentKettleOfFish {
    public static void main(String[] args){
        
        // while replacing 'while' loop for 'for' loop we moved an incrment and 
        // the initialization of the counter into the parseces fo the 'for-loop'
        for(int fish = 1; fish < 10; fish++){
            if(fish == 3){
                System.out.println("RED fish!");
            } else if(fish == 4){
                System.out.println("BLUE fish!");
            } else {
                System.out.println(fish + " fish!");
            }
            
        }
    }
}
