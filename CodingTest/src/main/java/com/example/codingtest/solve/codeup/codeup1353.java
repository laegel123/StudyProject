package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-29
 */
public class codeup1353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int x = 1;

        while (x <= n) {
            for (int i = 0; i < x; i++) {
                sb.append("*");
            }
            sb.append("\n");
            x++;
        }

        System.out.println(sb);
        br.close();
    }
}
