package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-20
 */
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        int[] countArr = new int[201];
        ListNode node = head;
        if (node != null) {
            countArr[node.val + 100]++;
        }

        while (node != null) {
            if (node.next == null) {
                break;
            }

            if (countArr[node.next.val + 100] > 0) {
                countArr[node.next.val + 100]++;
                countArr[node.next.val + 100]--;
                node.next = node.next.next;
            } else {
                countArr[node.next.val + 100]++;
                node = node.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode list = head;

        while (list != null) {
            if (list.next == null) {
                break;
            }

            if (list.val == list.next.val) {
                list.next = list.next.next;
            }
            else {
                list = list.next;
            }
        }

        return head;
    }
}

public class leetcode83 {
    public static void main(String[] args) {
        Solution83 solution = new Solution83();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.println(solution.deleteDuplicates(head));
        //System.out.println(solution.deleteDuplicates(null));
    }
}
