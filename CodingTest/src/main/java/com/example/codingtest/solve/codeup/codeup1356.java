package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-29
 */
public class codeup1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                int x = n;
                while (x-- > 0) sb.append("*");
                sb.append("\n");
            } else {
                for (int j = 0; j < n; j++) {
                    if (j == 0 || j == n - 1) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
