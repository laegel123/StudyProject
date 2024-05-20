package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-05-20
 */
public class Boj1463_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            if (i % 6 == 0) {
                arr[i] = Math.min(arr[i / 3], Math.min(arr[i / 2], arr[i - 1])) + 1;
            } else if (i % 3 == 0) {
                arr[i] = Math.min(arr[i / 3], arr[i - 1]) + 1;
            } else if (i % 2 == 0) {
                arr[i] = Math.min(arr[i / 2], arr[i - 1]) + 1;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }

        System.out.println(arr[n]);
        br.close();
    }
}
