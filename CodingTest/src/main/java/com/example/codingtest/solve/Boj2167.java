package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][m + 1];

        int totalSum = 0;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = totalSum;
            for (int j = 1; j < m + 1; j++) {
                totalSum += Integer.parseInt(st.nextToken());
                arr[i][j] = totalSum;
            }
        }

        int w = Integer.parseInt(br.readLine());
        while (w-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int resultSum = 0;
            for (int r = a; r < c + 1; r++) {
                resultSum += arr[r][d] - arr[r][b-1];
            }

            sb.append(resultSum).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
