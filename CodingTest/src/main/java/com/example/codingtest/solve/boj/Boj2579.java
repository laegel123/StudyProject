package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = stairs[i];
            } else if (i == 1) {
                dp[i] = stairs[i] + stairs[i - 1];
            } else if (i == 2) {
                dp[i] = stairs[i] + Math.max(stairs[i - 1], stairs[i - 2]);
            } else {
                dp[i] = stairs[i] + Math.max(dp[i - 2], stairs[i - 1] + dp[i - 3]);
            }
        }

        System.out.println(dp[n - 1]);
        br.close();
    }

}
