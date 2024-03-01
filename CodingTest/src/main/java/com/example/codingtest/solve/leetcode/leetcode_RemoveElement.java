package com.example.codingtest.solve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_RemoveElement {
    public static void main(String[] args) {
        removeElement(new int[]{3, 2, 2, 3}, 3);
    }

    public static int removeElement(int[] nums, int val) {
        List<Integer> numList = new ArrayList<>();

        for (int num : nums) {
            if (num != val) {
                numList.add(num);
            }
        }

        for (int i = 0; i < numList.size(); i++) {
            nums[i] = numList.get(i);
        }

        return numList.size();
    }
}
