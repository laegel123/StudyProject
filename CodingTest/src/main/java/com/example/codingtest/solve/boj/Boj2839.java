package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[5006];

        arr[3] = 1;
        arr[5] = 1;

        int i = 0;
        while (i <= n) {
            if (arr[i] != 0) {
                arr[i + 3] = arr[i + 3] != 0 ? Math.min(arr[i + 3], arr[i] + 1) : arr[i] + 1;
                arr[i + 5] = arr[i + 5] != 0 ? Math.min(arr[i + 5], arr[i] + 1) : arr[i] + 1;
            }
            i++;
        }

        if (arr[n] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(arr[n]);
        }
    }
}
