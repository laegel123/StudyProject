package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-03
 */
class Solution11_3 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int sum = minHeight * Math.abs(left - right);
            
            max = Math.max(sum, max);
            
            while (left < right && height[left] <= minHeight) left++;
            while (left < right && height[right] <= minHeight) right--;
        }
        
        return max;
    }
}

public class leetcode11_3 {
    public static void main(String[] args) {

    }
}
