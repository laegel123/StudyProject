package com.example.codingtest.solve.leetcode;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-12
 */

class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] countSortArray = new int[1001];

        for (int i = 0; i < arr1.length; i++) {
            countSortArray[arr1[i]]++;
        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            while (countSortArray[num]-- > 0) {
                arr1[index++] = num;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (countSortArray[i]-- > 0) {
                arr1[index++] = i;
            }
        }

        return arr1;
    }
}

public class leetcode1122 {
    public static void main(String[] args) {
        Solution1122 solution = new Solution1122();

    }
}
