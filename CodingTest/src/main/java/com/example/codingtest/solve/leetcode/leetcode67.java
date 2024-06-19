package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-19
 */

class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int up = 0;
        while (index < a.length() || index < b.length() || up == 1) {
            int ac = 0;
            int bc = 0;
            if (index < a.length()) {
                ac = a.charAt(a.length() - 1 - index) - '0';
            }
            if (index < b.length()) {
                bc = b.charAt(b.length() - 1 - index) - '0';
            }
            
            int sum = ac + bc + up;
            
            up = sum / 2;
            sb.append(sum % 2);
            index++;
        }
        
        return sb.reverse().toString();
    }
}


public class leetcode67 {
    public static void main(String[] args) {
        Solution67 solution = new Solution67();
        System.out.println(solution.addBinary("11", "1"));
    }
}
