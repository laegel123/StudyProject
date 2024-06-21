package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-20
 */

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        
        if(p == null || q == null || p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class leetcode100 {
    public static void main(String[] args) {
        Solution100 solution = new Solution100();
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        System.out.println(solution.isSameTree(p, q));
    }
}
