package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-13
 */
class Solution27_2 {
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[index++] = nums[i];
        }

        return index;
    }
}

public class leetcode27_2 {
    public static void main(String[] args) {

    }
}
