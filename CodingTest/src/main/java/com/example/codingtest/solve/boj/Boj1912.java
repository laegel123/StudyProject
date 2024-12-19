package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) dp[i] = arr[i];
            else {
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        br.close();
    }

}