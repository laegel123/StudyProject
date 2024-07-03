package com.example.codingtest.solve.leetcode;

import java.util.Arrays;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-03
 */
class Solution1_3 {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int[] copyNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copyNums[i] = nums[i];
        }

        Arrays.sort(nums);
        
        while (start < end) {
            int sum = nums[start] + nums[end];
            
            if (sum < target) {
                start++;
            }
            else if (sum > target) {
                end--;
            }
            else {
                int[] result = new int[2];
                int idx = 0;
                for (int i = 0; i < copyNums.length; i++) {
                    if (nums[start] == copyNums[i] || nums[end] == copyNums[i]) {
                        result[idx++] = i;
                    }
                }

                return result;
            }
        }

        
        return new int[]{};
    }
}

public class leetcode1_3 {
    public static void main(String[] args) {
        Solution1_3 solution = new Solution1_3();
        int[] result = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
