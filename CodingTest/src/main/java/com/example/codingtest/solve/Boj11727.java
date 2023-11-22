package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11727 {
    static int[] ARR = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ARR[1] = 1;
        ARR[2] = 3;

        for (int i = 3; i < n + 1; i++) {
            ARR[i] = (ARR[i - 1] + 2 * ARR[i - 2]) % 10007;
        }

        System.out.println(ARR[n]);
        br.close();
    }
}
