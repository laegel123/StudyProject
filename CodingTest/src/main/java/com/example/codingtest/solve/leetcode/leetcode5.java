package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-21
 */

class Solution5 {
    public String longestPalindrome(String s) {
        String result = "";

        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                result = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
                break;
            }

            if (i > 0 && s.charAt(i - 1) == s.charAt(i + 1)) {
                result = String.valueOf(s.charAt(i - 1)) + String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
            }
        }

        return result;
    }
}

public class leetcode5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        System.out.println(solution.longestPalindrome("babad"));
    }
}
