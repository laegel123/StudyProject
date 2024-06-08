package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-07
 */
class Solution136 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        return ret;
    }
}

public class leetcode136 {
    public static void main(String[] args) {
        Solution136 solution = new Solution136();
        solution.singleNumber(new int[]{1, 5, 2, 5, 2});
    }
}
