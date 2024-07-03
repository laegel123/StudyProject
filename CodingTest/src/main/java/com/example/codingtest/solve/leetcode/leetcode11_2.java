package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-03
 */
class Solution11_2 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        
        while (left < right) {
            result = Math.max(result, Math.abs(left - right) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return result;
    }
}

public class leetcode11_2 {
    public static void main(String[] args) {

    }
}
