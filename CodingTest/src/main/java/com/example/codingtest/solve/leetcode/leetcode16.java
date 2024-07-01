package com.example.codingtest.solve.leetcode;

import java.util.Arrays;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-01
 */
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int absDif = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int targetNum = nums[i] + nums[left] + nums[right];
                int dif = targetNum - target;

                if (Math.abs(dif) < Math.abs(absDif)) {
                    result = targetNum;
                    absDif = Math.abs(dif);

                    if (dif < 0) {
                        left++;
                    }
                    else if (dif > 0) {
                        right--;
                    }
                    else {
                        return targetNum;
                    }

                    continue;
                }

                if (dif < 0) {
                    left++;
                }
                else if (dif > 0) {
                    right--;
                }

            }
        }

        return result;
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}

public class leetcode16 {
    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        solution.threeSumClosest(new int[]{0, 1, 2}, 3);
    }
}
