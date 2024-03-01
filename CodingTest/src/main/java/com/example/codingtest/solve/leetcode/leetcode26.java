package com.example.codingtest.solve.leetcode;

import java.util.*;

public class leetcode26 {
    public static void main(String[] args) {
        removeDuplicates(new int[]{-3, -1, 0, 0, 0, 3, 3});
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }

        return index;
    }
}
