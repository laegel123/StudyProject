package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-02
 */
/*
1 2 3 2 1 -> 1 3 1 2 2
1. 처음으로 감소하는 부분 찾기.
2. 감소하는 부분 오른쪽에서 감소하는 부분보다 큰 값 찾기
3. 스왑
4. 스왑한 오른쪽 정렬
*/
class Solution31 {
    public void nextPermutation(int[] nums) {
        int x = nums.length - 2;        
        while (x >= 0 && nums[x] >= nums[x + 1]) x--;

        if (x >= 0) {
            int y = nums.length - 1;
            while (y >= 0 && nums[y] <= nums[x]) y--;
            swap(nums, x, y);
        }

        int start = x + 1;
        int end = nums.length - 1;
        
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
}

public class leetcode31 {
    public static void main(String[] args) {
        Solution31 solution = new Solution31();
        solution.nextPermutation(new int[]{1, 2, 3});
        solution.nextPermutation(new int[]{1, 1, 5});
        solution.nextPermutation(new int[]{3, 2, 1});
        solution.nextPermutation(new int[]{1, 3, 2});
    }
}
