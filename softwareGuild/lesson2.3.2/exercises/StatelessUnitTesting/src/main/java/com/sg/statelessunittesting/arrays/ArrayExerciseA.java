package com.sg.statelessunittesting.arrays;

public class ArrayExerciseA {
    
    /**
     * Given an array of ints, find and return the maximum value.
     * 
     * Example Results:
     * maxOfArray( {1}  ) ->  1
     * maxOfArray( {3,4,5}  ) ->  5
     * maxOfArray( {-9000, -700, -50, -3}  ) ->  -3
     * 
     * @param numbers array of integers
     * @return int max
     */
    public static int maxOfArray(int[] numbers){
        int maxNumber = numbers[0];
        
            if(numbers.length == 1){
                maxNumber = numbers[0];
            } else {
                for(int i = 0; i < numbers.length; i++){
                    if (numbers[i] > maxNumber){
                        maxNumber = numbers[i];
                    }
               } 
            }
        
        return maxNumber;
    }
        
}
