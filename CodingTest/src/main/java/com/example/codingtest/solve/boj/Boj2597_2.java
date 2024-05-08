package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-05-07
 */
public class Boj2597_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[n + 1];
        result[1] = arr[1];
        if (n >= 2) {
            result[2] = arr[1] + arr[2];
        }

        for (int i = 3; i < n + 1; i++) {
            result[i] = arr[i] + Math.max(result[i - 3] + arr[i - 1], result[i - 2]);
        }

        System.out.println(result[n]);
        br.close();
    }
}
