package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-20
 */
class Solution70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public int climbStairs2(int n) {
        if (n == 1) return 1;
        int cur = 1;
        int prev = 1;

        for (int i = 2; i < n + 1; i++) {
            int temp = cur;
            cur = cur + prev;
            prev = temp;
        }

        return cur;
    }
}

public class leetcode70 {
    public static void main(String[] args) {
        Solution70 solution = new Solution70();
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs2(3));
        System.out.println(solution.climbStairs2(4));
    }
}
