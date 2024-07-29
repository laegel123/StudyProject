package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-29
 */
public class codeup1355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                sb.append(" ");
            }

            for (int k = 0; k < i; k++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
