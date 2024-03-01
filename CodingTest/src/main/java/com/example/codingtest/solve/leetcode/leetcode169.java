package com.example.codingtest.solve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode169 {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], maps.getOrDefault(nums[i], 0) + 1);
        }

        int result = 0;
        int n = nums.length / 2;
        for (Map.Entry<Integer, Integer> map : maps.entrySet()) {
            if (map.getValue() > n) {
                result = map.getKey();
                break;
            }
        }

        return result;
    }
}
