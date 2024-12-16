package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj15486 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2];
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        for (int i = n; i >= 1; i--) {
            if (i + t[i] <= n + 1) dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
            else dp[i] = dp[i + 1];
        }

        System.out.println(dp[1]);
        br.close();
    }

}
