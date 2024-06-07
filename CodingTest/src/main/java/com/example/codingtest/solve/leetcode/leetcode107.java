package com.example.codingtest.solve.leetcode;

import java.util.*;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-07
 */

class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        if (root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++ ) {
                TreeNode now = q.poll();
                list.add(now.val);

                if (now.left != null) q.offer(now.left);
                if (now.right != null) q.offer(now.right);
            }

            ret.add(0, list);

        }

        return ret;
    }
}

public class leetcode107 {
    public static void main(String[] args) {

        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode n15 = new TreeNode(15, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n3 = new TreeNode(3, n9, n20);

        Solution107 solution = new Solution107();
        List<List<Integer>> lists = solution.levelOrderBottom(n3);

        System.out.println(lists);

    }

}
