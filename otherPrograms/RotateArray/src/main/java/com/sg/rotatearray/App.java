package com.sg.rotatearray;

public class App {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        RotateArray rotateArray = new RotateArray();

        rotateArray.rotate(nums, k);
        
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
    }
}
