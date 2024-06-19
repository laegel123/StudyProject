package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-19
 */

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        if (nums[mid] < target) {
            return mid + 1;
        }
        else {
            return mid;
        }
    }
}

public class leetcode35 {
    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}
