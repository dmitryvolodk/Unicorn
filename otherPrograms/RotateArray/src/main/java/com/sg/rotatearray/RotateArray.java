package com.sg.rotatearray;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k % nums.length;
        }
        
        int[] ary = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if ((i + k + 1) > nums.length) {
                ary[(i + k) - nums.length] = nums[i];
            } else {
                ary[i + k] = nums[i];
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = ary[i];
        }
    }
}
