package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        int y = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            y++;
        }

        int max = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][0] = arr[0][0];
                max = dp[0][0];
            }
            else {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0) dp[i][j] = dp[i - 1][j] + arr[i][j];
                    else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
        br.close();
    }

}
