package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] prefixSum = new long[n + 1];
        long[] sumCount = new long[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            prefixSum[i] = (prefixSum[i - 1] + Integer.parseInt(st.nextToken())) % m ;
            sumCount[(int) prefixSum[i]]++;
        }


        long count = sumCount[0];
        for (int i = 0; i < m; i++) {
            if (sumCount[i] > 1) {
                count += (sumCount[i] * (sumCount[i] - 1) / 2);
            }
        }

        System.out.println(count);
        br.close();
    }
}
