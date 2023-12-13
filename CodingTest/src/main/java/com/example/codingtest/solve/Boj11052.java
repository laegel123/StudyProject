package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] pay = new int[n + 1];
        int[] max = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            max[i] = pay[i];
            for (int j = 1; j < i; j++) {
                max[i] = Math.max(max[i], pay[j] + max[i - j]);
            }
        }

        System.out.println(max[n]);
    }
}
