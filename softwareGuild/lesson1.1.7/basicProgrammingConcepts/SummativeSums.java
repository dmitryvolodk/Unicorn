/*
* Program name: Summative Sums
* Author: Dmitry Volodkevich
* Date created: 08/06/2020
* Date revised: 
*/

package com.sg.summativesums;

public class SummativeSums {
    public static void main(String[] args){
        // Create an array of arrays to better automate the operations with arrays
        int[][] arrays = {{ 1, 90, -33, -55, 67, -16, 28, -55, 15 },
                { 999, -60, -77, 14, 160, 301 },
                { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 }};
        
        // Display sums of arrays
        for(int i = 0; i < arrays.length; i++ ){
            System.out.println("#" + (i + 1) + " Array Sum:" + addElements(arrays[i]));
        }
    }
    
    // Method to sum the elements of an array
    public static int addElements(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
}
