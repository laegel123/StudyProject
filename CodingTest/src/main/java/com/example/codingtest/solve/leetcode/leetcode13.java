package com.example.codingtest.solve.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-12
 */
class Solution13 {
    public int romanToInt(String s) {
        int answer = 0;
        Map<Character, Integer> m = new HashMap<>();

        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i+1))) {
                answer -= m.get(s.charAt(i));
            } else {
                answer += m.get(s.charAt(i));
            }
        }

        return answer;
    }
}

public class leetcode13 {
    public static void main(String[] args) {
        Solution13 solution = new Solution13();
        System.out.println(solution.romanToInt("VX"));
    }
}
