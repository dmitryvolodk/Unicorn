package com.sg.simplesort;

public class SimpleSort {
    public static void main(String[] args){
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};
        
        int[] wholeNumber = new int[24];
        int k = wholeNumber.length / 2;
        
        for(int i = 0; i < firstHalf.length; i++){
            wholeNumber[i] = firstHalf[i];
            wholeNumber[k] = secondHalf[i];
            k++;
        }
        
        int temp;
        
        for(int i = 1; i < wholeNumber.length; i++){
            for(int j = 0; j < wholeNumber.length - 1; j++){
                if(wholeNumber[j] > wholeNumber[j+1]){
                    temp = wholeNumber[j];
                    wholeNumber[j] = wholeNumber[j+1];
                    wholeNumber[j+1] = temp;
                }
            }
        }
        
        System.out.println("Here ya go - all nice and ordered: ");
        for(int m = 0; m < wholeNumber.length; m++){
            System.out.print(wholeNumber[m] + " ");
        }
    }
}
