package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-23
 */

class Solution104 {
    public int maxDepth(TreeNode root) {
        int depth = getDepth(root, 0);

        return depth;
    }

    public int getDepth(TreeNode root, int depth) {
        if (root == null) return depth;

        return Math.max(getDepth(root.left, depth + 1), getDepth(root.right, depth + 1));
    }
}

public class leetcode104 {
    public static void main(String[] args) {
        Solution104 solution = new Solution104();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solution.maxDepth(root));
    }
}
