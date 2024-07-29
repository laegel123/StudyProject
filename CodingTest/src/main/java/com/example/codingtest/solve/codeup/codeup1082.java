package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-29
 */
public class codeup1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int n = Integer.parseInt(s, 16);

        for (int i = 1; i <= 15; i++) {
            sb.append(String.format("%s*%X=%X", s, i, n * i)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
