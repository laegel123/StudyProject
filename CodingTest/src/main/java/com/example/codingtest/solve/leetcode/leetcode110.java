package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-23
 */
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) return -1;

        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) return -1;

        if (Math.abs(leftDepth - rightDepth) > 1) return -1;

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

public class leetcode110 {
    public static void main(String[] args) {
        Solution110 solution = new Solution110();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);

        System.out.println(solution.isBalanced(root));

    }
}
