package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[][] count = new long[100002][4];
        int mod = 1000000009;

        count[1][1] = 1;
        count[2][2] = 1;
        count[3][3] = 1;
        count[3][1] = 1;
        count[3][2] = 1;

        for (int i = 4; i < 100001; i++) {
            count[i][1] = (count[i - 1][2] + count[i - 1][3]) % mod;
            count[i][2] = (count[i - 2][1] + count[i - 2][3]) % mod;
            count[i][3] = (count[i - 3][1] + count[i - 3][2]) % mod;
        }

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            sb.append((count[x][1] + count[x][2] + count[x][3]) % mod).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
