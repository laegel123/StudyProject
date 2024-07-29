package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-29
 */
public class codeup1351 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = x; i <= y; i++) {
            for (int j = 1; j < 10; j++) {
                sb.append(String.format("%s*%s=%d", i, j, i * j)).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
