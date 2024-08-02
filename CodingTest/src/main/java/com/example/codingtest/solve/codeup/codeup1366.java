package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-02
 */
public class codeup1366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int half = n / 2;

        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1
                        || i == half || j == half
                ) {
                    sb.append("*");
                } else {
                    if (j == x || j == n - 1 - x) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            }

            x++;
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();

    }
}
