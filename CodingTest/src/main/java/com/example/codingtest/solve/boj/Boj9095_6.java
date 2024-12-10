package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj9095_6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
