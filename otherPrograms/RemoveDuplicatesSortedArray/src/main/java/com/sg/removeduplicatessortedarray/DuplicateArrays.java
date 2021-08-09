package com.sg.removeduplicatessortedarray;

public class DuplicateArrays {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        int l = 0;

        for (int i = 1; i < nums.length - l; i++) {
            if (nums[i] == nums[i - 1]) {
                for(int b = i; b < nums.length - l; b++){
                    nums[b-1] = nums[b];
                }
                i--;
                l++;
            }
        }

        k = nums.length - l;
        
        return k;
    }
}
