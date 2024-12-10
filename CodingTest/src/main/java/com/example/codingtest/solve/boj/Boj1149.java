package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3]; // R, G, B

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }

        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
        br.close();
    }

}
