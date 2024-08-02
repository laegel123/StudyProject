package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-02
 */
public class codeup1367 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int x = n - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < x; j++) {
                sb.append(" ");
            }

            for (int j = x; j < x + n; j++) {
                sb.append("*");
            }

            x--;
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
