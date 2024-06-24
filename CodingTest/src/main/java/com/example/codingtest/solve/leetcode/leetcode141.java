package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-24
 */
class Solution141 {

    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == 100001) return true;
            
            head.val = 100001;
            head = head.next;
        }
        
        return false;
    }
}

public class leetcode141 {
    public static void main(String[] args) {
        Solution141 solution = new Solution141();
        ListNode head = new ListNode(1);
        System.out.println(solution.hasCycle(head));
    }
}
