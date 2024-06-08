package com.example.codingtest.solve.leetcode;

import java.util.Arrays;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-08
 */
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] newArray = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            newArray[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            newArray[nums1.length + i] = nums2[i];
        }

        Arrays.sort(newArray);

        int length = newArray.length;
        if (length % 2 != 0) {
            return (double) newArray[length/2];
        } else {
            return (double) (newArray[length / 2 - 1] + newArray[length / 2]) / 2;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }
    }
}

public class leetcode4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(solution.findMedianSortedArrays2(new int[]{1, 2}, new int[]{3, 4}));
    }
}
