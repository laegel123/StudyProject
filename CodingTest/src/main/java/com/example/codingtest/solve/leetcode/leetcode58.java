package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-19
 */
class Solution58 {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");

        return str[str.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        int length = 0;
        boolean start = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                start = true;
            }

            if (start) {
                length++;
                if (s.charAt(i) == ' ') {
                    length--;
                    break;
                }
            }
        }

        return length;
    }
}

public class leetcode58 {
    public static void main(String[] args) {
        Solution58 solution = new Solution58();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
}
