package com.sg.containsduplicateprog;

public class App {
    public static void main(String[] args){
        ContainsDuplicate duplicate = new ContainsDuplicate();
        int[] nums = {1,2,3,1};
        
        boolean isDuplicate = duplicate.containsDuplicate(nums);
        
        System.out.println(isDuplicate);
    }
}
