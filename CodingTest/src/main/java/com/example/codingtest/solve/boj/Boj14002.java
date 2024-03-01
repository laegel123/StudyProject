package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int maxCount = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        maxCount = 1;


        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxCount = Math.max(maxCount, dp[i]);
                }
            }
        }

        sb.append(maxCount).append("\n");

        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == maxCount) {
                s.push(arr[i]);
                maxCount--;
            }
        }

        while (s.size() > 0) {
            sb.append(s.pop()).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
