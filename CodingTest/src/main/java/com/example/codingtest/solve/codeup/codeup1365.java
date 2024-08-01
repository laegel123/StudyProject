package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-01
 */
public class codeup1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1) {
                    sb.append("*");
                } else {
                    if (j == 0 || j == x || j == n - x - 1 || j == n - 1) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            }

            sb.append("\n");
            x++;
        }

        System.out.println(sb);
        br.close();
    }
}
