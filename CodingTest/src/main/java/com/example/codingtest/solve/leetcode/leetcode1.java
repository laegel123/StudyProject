package com.example.codingtest.solve.leetcode;

import java.util.HashMap;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-08
 */


/*
대안 1. brute-force -> n * n-1

 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            int findNum = target - nums[i];

            int findIndex = findNum(nums, i + 1, findNum);
            if (findIndex > -1) {
                result[0] = i;
                result[1] = findIndex;
            }
        }

        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // key : target - 배열값, value: 배열의 인덱스

        for (int i = 0; i < nums.length; i++) {
            int cur = target - nums[i];

            if (map.containsKey(cur)) {
                return new int[]{i, map.get(cur)};
            } else {
                map.put(cur, i);
            }
        }

        return new int[]{};
    }

    public int findNum(int[] nums, int startIndex, int findNum) {
        int findIndex = -1;
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] == findNum) {
                return i;
            }
        }

        return findIndex;
    }
}

public class leetcode1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.twoSum2(new int[]{3, 3}, 6);
    }
}
