package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (k < n) {
            Integer[] sensors = new Integer[n];
            for (int i = 0; i < n; i++) {
                sensors[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sensors);

            Integer[] diff = new Integer[n - 1];
            for (int i = 0; i < n - 1; i++) {
                diff[i] = sensors[i + 1] - sensors[i];
            }

            Arrays.sort(diff);

            for (int i = 0; i < n - k; i++) {
                answer += diff[i];
            }
        }

        System.out.println(answer);
        br.close();
    }
}
