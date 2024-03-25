package com.example.codingtest.solve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode80_1 {
    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
    }

    public static int removeDuplicates(int[] nums) {
        int[] countArr = new int[6001];
        for (int num : nums) {
            countArr[num + 3000]++;
        }

        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 1) {
                nums[index++] = i - 3000;
            } else if (countArr[i] > 1) {
                nums[index++] = i - 3000;
                nums[index++] = i - 3000;
            }
        }

        return index;
    }
}
