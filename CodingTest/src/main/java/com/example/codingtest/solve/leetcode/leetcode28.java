package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-19
 */

class Solution28 {
    public int strStr(String haystack, String needle) {
        char n1 = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);

            if (c == n1) {
                if (haystack.length() - i < needle.length()) {
                    return -1;
                }

                int index = 0;
                boolean bool = true;
                while (index < needle.length()) {
                    if (needle.charAt(index) != haystack.charAt(i + index)) {
                        bool = false;
                        break;
                    }

                    index++;
                }

                if (bool) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == needle.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
}

public class leetcode28 {
    public static void main(String[] args) {
        Solution28 solution = new Solution28();
        System.out.println(solution.strStr("a", "a"));
        //System.out.println(solution.strStr("sadbutsad", "sad"));
        //System.out.println(solution.strStr("leetcode", "leeto"));


    }
}
