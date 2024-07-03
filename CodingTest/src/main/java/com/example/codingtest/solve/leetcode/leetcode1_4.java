package com.example.codingtest.solve.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-03
 */
class Solution1_4 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{i, map.get(target - nums[i])};
            
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
}
public class leetcode1_4 {
    public static void main(String[] args) {
        Solution1_4 solution = new Solution1_4();
        int[] result = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
