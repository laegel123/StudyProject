package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-01
 */
public class Boj11727_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }

        System.out.println(dp[n]);
        br.close();
    }
}
