package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-13
 */

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            int length = Math.min(str.length(), commonPrefix.length());
            commonPrefix = commonPrefix.substring(0, length);
            for (int j = 0; j < length; j++) {
                if (commonPrefix.charAt(j) != str.charAt(j)) {
                    commonPrefix = commonPrefix.substring(0, j);
                    break;
                }
            }
        }

        return commonPrefix;
    }
}


public class leetcode14 {
    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        System.out.println(solution.longestCommonPrefix(new String[]{"aaa", "aa", "aaa"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"ab", "a"}));

    }
}
