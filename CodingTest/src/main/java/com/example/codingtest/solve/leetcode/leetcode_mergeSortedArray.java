package com.example.codingtest.solve.leetcode;

import java.util.Arrays;

public class leetcode_mergeSortedArray {
    public static void main(String[] args) {

        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);

        System.out.println(nums1);
    }
}
