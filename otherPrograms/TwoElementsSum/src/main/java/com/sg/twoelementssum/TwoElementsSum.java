package com.sg.twoelementssum;

import java.util.HashMap;
import java.util.Map;

public class TwoElementsSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 1; i < nums.length; i++) {
            for (int k = i - 1; k >= 0; k--) {
                if ((nums[k] + nums[i]) == target) {
                    result[0] = k;
                    result[1] = i;
                    return result;
                }
            }
        }
        return result;

        /*    Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
                map.put(i, nums[i]);
            if (map.size() >= 2) {
                for (int key : map.keySet()) {
                    if (key != i && (map.get(i) + map.get(key)) == target) {
                        result[0] = key;
                        result[1] = i;
                        return result;
                    }
                }
            }
        }

        return result;
         */
    }
}
