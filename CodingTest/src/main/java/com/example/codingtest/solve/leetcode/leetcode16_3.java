package com.example.codingtest.solve.leetcode;

import java.util.Arrays;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-12
 */
class Solution16_3 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - closet)) closet = sum;

                if (sum < target) {
                    left++;
                }
                else if (sum > target) {
                    right--;
                }
                else {
                    return closet;
                }
            }
        }

        return closet;
    }
}

public class leetcode16_3 {
    public static void main(String[] args) {
        Solution16_3 solution = new Solution16_3();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
