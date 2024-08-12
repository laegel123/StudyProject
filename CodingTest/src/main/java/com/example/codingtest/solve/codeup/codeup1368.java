package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-11
 */
public class codeup1368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String d = st.nextToken();

        for (int i = 0; i < n; i++) {
            if (d.equals("L")) {
                for (int j = 0; j < i; j++) {
                    sb.append(" ");
                }
            } else if (d.equals("R")) {
                for (int j = n - 1; j > i; j--) {
                    sb.append(" ");
                };
            }

            for (int j = 0; j < m; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
