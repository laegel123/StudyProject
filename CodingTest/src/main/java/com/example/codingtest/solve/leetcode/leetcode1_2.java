package com.example.codingtest.solve.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-30
 */
class Solution1_2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            
            if (map.containsKey(target - cur)) {
                return new int[]{map.get(target - cur), i};
            }
            
            map.put(cur, i);
        }
        
        return new int[]{};
    }
}

public class leetcode1_2 {
    public static void main(String[] args) {
        Solution1_2 solution = new Solution1_2();
        solution.twoSum(new int[]{3, 3}, 6);
    }
}
