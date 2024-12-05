package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeup2653 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][2];
        dp[1][1] = 1;
        dp[1][0] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        System.out.println(dp[n][0] + dp[n][1]);
        br.close();
    }

}
