package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-23
 */
class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode getBinaryTree(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getBinaryTree(nums, start, mid - 1);
        root.right = getBinaryTree(nums, mid + 1, end);

        return root;
    }
}

public class leetcode108 {
    public static void main(String[] args) {
        Solution108 solution = new Solution108();
        TreeNode root = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right.val);
    }
}
