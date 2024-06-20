package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-20
 */

class Solution69 {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        int mid = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if ((long) mid * mid == (long) x) {
                return mid;
            }
            else if ((long) mid * mid > (long) x) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return end;
    }
}

public class leetcode69 {
    public static void main(String[] args) {
        Solution69 solution = new Solution69();
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(2147395599));
    }
}
