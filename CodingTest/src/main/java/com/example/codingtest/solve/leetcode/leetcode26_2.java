package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-13
 */
class Solution26_2 {
    public int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }

        return index;
    }
}

public class leetcode26_2 {
    public static void main(String[] args) {
        Solution26_2 solution = new Solution26_2();
        solution.removeDuplicates(new int[]{1, 1, 2});
    }
}
