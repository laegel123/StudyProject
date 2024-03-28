package com.example.codingtest.solve.leetcode;

public class leetcode121 {
    public static void main(String[] args) {
        maxProfit(new int[]{7,1,5,3,6,4});
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int minNum = Integer.MAX_VALUE;
        for (int price : prices) {
            if (minNum > price) {
                minNum = price;
            } else {
                max = Integer.max(max, price - minNum);
            }
        }

        return max;
    }
}
