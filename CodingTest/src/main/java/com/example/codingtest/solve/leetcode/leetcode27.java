package com.example.codingtest.solve.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-03-25
 */
public class leetcode27 {
    public static void main(String[] args) {

    }

    static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }

            nums[index] = nums[i];
            index++;
        }

        return index;
    }
}
