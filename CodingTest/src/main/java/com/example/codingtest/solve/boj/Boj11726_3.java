package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-05-30
 */
public class Boj11726_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        arr[1] = 1;
        if (n > 1) {
            arr[2] = 2;

            for (int i = 3; i < n + 1; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
            }
        }

        System.out.println(arr[n]);
        br.close();
    }
}
