package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-12
 */

class Solution9 {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int lastIndex = str.length();

        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(lastIndex-1)) {
                return false;
            }

            lastIndex--;
        }

        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        long reversed = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) (temp % 10);
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return (reversed == x);
    }
}

public class leetcode9 {
    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        //solution.isPalindrome(11);
        solution.isPalindrome2(121);
    }
}
