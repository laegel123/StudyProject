package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-24
 */
class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        return isTargetSum(root, 0, targetSum);
    }
    
    public boolean isTargetSum(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }

        sum += node.val;
        if (sum == targetSum  && node.left == null && node.right == null) {
            return true;
        }
        
        return isTargetSum(node.left, sum, targetSum) || isTargetSum(node.right, sum, targetSum);
    }
}

public class leetcode112 {
    public static void main(String[] args) {
        Solution112 solution = new Solution112();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(solution.hasPathSum(root, 1));
    }
}
