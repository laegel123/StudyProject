package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1003_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] count = new int[41][2];

        for (int i = 0; i < count.length; i++) {
            if (i == 0) {
                count[i][0] = 1;
                count[i][1] = 0;
            } else if (i == 1) {
                count[i][0] = 0;
                count[i][1] = 1;
            } else {
                count[i][0] = count[i - 1][0] + count[i - 2][0];
                count[i][1] = count[i - 1][1] + count[i - 2][1];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(count[n][0]).append(" ").append(count[n][1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
