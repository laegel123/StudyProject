package com.example.codingtest.solve.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-08
 */

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int length = s.length();
        if (length < 2 || length % 2 != 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            char bracket = s.charAt(i);

            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else {
                if (stack.size() == 0) {
                    return false;
                } else if (bracket == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                } else if (bracket == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                } else if (bracket == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}

public class leetcode20 {
    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        System.out.println(solution.isValid("([]){"));
    }
}
