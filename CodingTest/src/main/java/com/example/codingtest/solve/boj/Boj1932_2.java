package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-01
 */
public class Boj1932_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxNum = 0;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        int index = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < index; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            index++;
        }

        dp[0][0] = arr[0][0];
        maxNum = dp[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                }

                maxNum = Math.max(maxNum, dp[i][j]);
            }
        }

        System.out.println(maxNum);
        br.close();
    }
}
