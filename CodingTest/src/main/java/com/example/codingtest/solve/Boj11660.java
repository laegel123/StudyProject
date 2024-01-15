package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int totalSum = 0;
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                totalSum += arr[i][j];
                sum[i][j] = totalSum;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            int total = 0;
            for (int i = x1; i < x2 + 1; i++) {
                total += sum[i][y2] - sum[i][y1 - 1];
            }

            sb.append(total).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
