package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-23
 */
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isNodeSymmetric(root.left, root.right);
    }

    public boolean isNodeSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null || (leftNode.val != rightNode.val)) return false;

        return isNodeSymmetric(leftNode.left, rightNode.right) && isNodeSymmetric(leftNode.right, rightNode.left);
    }
}

public class leetcode101 {
    public static void main(String[] args) {
        Solution101 solution = new Solution101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(solution.isSymmetric(root));
    }
}
