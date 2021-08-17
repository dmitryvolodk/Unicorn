package com.sg.containsduplicateprog;
import java.util.Arrays;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        boolean idDuplicate = false;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        
        return idDuplicate;
    }
}
