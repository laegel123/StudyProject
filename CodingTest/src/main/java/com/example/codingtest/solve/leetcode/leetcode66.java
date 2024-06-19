package com.example.codingtest.solve.leetcode;

import java.util.Arrays;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-19
 */
class Solution66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }

        if (digits[0] == 0) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            for (int i = 0; i < digits.length - 1; i++) {
                newArray[i + 1] = digits[i];
            }

            return newArray;
        } else {
            return digits;
        }
    }
}

public class leetcode66 {
    public static void main(String[] args) {
        Solution66 solution = new Solution66();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
    }
}
