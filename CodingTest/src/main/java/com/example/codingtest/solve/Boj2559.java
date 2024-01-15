package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dateCount = Integer.parseInt(st.nextToken());
        int continuousDateNum = Integer.parseInt(st.nextToken());
        int[] temperatures = new int[dateCount];
        int[] prefixSum = new int[dateCount + 1];
        int maxTemperature = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dateCount; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
            prefixSum[i + 1] = temperatures[i] + prefixSum[i];
        }

        for (int i = continuousDateNum; i < dateCount + 1; i++) {
            maxTemperature = Math.max(maxTemperature, prefixSum[i] - prefixSum[i - continuousDateNum]);
        }

        System.out.println(maxTemperature);
        br.close();
    }
}
