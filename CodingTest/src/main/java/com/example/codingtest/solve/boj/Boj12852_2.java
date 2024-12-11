package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj12852_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] visited = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            visited[i] = i - 1;

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                visited[i] = i / 3;
            }

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                visited[i] = i / 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");

        while (n > 0) {
            sb.append(n).append(" ");
            n = visited[n];
        }
        
        System.out.println(sb);
        br.close();
    }

}
