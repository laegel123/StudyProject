package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 9901;
        int[][] count = new int[n + 1][3];

        count[1][0] = count[1][1] = count[1][2] = 1;

        for (int i = 2; i < n + 1; i++) {
            count[i][0] = (count[i - 1][0] + count[i - 1][1] + count[i - 1][2]) % mod;
            count[i][1] = (count[i - 1][0] + count[i - 1][2]) % mod;
            count[i][2] = (count[i - 1][0] + count[i - 1][1]) % mod;
        }

        System.out.println((count[n][0] + count[n][1] + count[n][2]) % mod);
    }
}
