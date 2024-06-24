package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-24
 */
class Solution125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        if (s.isEmpty()) return true;
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        
        return true;
    }
}

public class leetcode125 {
    public static void main(String[] args) {
        Solution125 solution = new Solution125();
        //System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(solution.isPalindrome("race a car"));
        //System.out.println(solution.isPalindrome("aa"));
        System.out.println(solution.isPalindrome("0P"));
        //System.out.println(solution.isPalindrome(" "));

    }
}
