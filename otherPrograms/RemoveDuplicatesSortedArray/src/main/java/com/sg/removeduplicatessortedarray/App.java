package com.sg.removeduplicatessortedarray;

public class App {
    public static void main(String[] args){
        DuplicateArrays duplicates = new DuplicateArrays();
        int[] nums = {1,1,1,2,2,3,4,5,5,5,5,6};
        
        int k = duplicates.removeDuplicates(nums);
        
        System.out.println("k = " + k);
        
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
    }
}
