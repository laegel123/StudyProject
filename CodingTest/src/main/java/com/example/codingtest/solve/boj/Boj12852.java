package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-05-31
 */
public class Boj12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }
        }

        sb.append(dp[n]).append("\n");

        while (n > 0) {
            sb.append(n).append(" ");
            n = path[n];
        }

        System.out.println(sb);
        br.close();
    }
}
