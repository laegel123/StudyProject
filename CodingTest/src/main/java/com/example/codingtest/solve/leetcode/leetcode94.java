package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-07
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    List<Integer> ret;
    public List<Integer> inorderTraversal(TreeNode root) {
        ret = new ArrayList<>();
        inorder(root);
        return ret;
    }

    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            ret.add(node.val);
            inorder(node.right);
        }
    }
}

public class leetcode94 {
    List<Integer> ret;
    public List<Integer> inorderTraversal(TreeNode root) {
        ret = new ArrayList<>();
        inorder(root);
        return ret;
    }

    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            ret.add(node.val);
            inorder(node.right);
        }
    }

    public static void main(String[] args) {

    }
}
