package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-18
 */
public class codeup1441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                long left = arr[j];
                long right = arr[j + 1];

                if (right < left) {
                    arr[j] = right;
                    arr[j + 1] = left;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }


}
