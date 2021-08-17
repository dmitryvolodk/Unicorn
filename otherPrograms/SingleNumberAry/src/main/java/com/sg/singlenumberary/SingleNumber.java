package com.sg.singlenumberary;

import java.util.Arrays;

public class SingleNumber {
    public int singleNum(int[] nums){
        int num = 0;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            if((i+1) <= nums.length - 1 && nums[i] != nums[i+1] && i % 2 == 0){
                return nums[i];
            } else if (i == nums.length - 1 && nums.length % 2 != 0) {
                return nums[i];
            }
        }
        return num;
    }
}
