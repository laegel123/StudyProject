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
public class codeup1095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minNum = Integer.MAX_VALUE;

        while (n-- > 0) {
            minNum = Math.min(minNum, Integer.parseInt(st.nextToken()));
        }

        System.out.println(minNum);
        br.close();

    }
}
