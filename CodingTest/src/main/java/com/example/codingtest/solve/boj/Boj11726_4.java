package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj11726_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else if (i == 1) {
                dp[i] = 2;
            } else if (i == 2) {
                dp[i] = 3;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }

        System.out.println(dp[n - 1]);
        br.close();;
    }

}
