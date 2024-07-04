package com.example.codingtest.solve.leetcode;

import java.util.Arrays;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-04
 */
class Solution16_2 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetSize = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - closetSize)) {
                    closetSize = sum;
                }
                
                if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        
        return closetSize;
    }
}

public class leetcode16_2 {
    public static void main(String[] args) {
        Solution16_2 solution = new Solution16_2();
        solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }
}
