package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-15
 */
class Solution31_2 {
    public void nextPermutation(int[] nums) {
        int x = nums.length - 2;
        while (x >= 0 && nums[x] >= nums[x + 1]) x--;

        if (x >= 0) {
            int y = nums.length - 1;
            while (y >= 0 && nums[y] <= nums[x]) y--;

            swap(nums, x, y);
        }

        int left = x + 1;
        int right = nums.length - 1;

        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}

public class leetcode31_2 {
    public static void main(String[] args) {
        Solution31_2 solution = new Solution31_2();
        //solution.nextPermutation(new int[]{1, 2, 3});
        //solution.nextPermutation(new int[]{1, 1, 5});
        solution.nextPermutation(new int[]{3, 2, 1});
    }
}
