package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-09-30
 */
public class codeup3704 {
    static int[] MEMORY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MEMORY = new int[n + 1];

        if (n >= 1) MEMORY[1] = 1;
        if (n >= 2) MEMORY[2] = 2;
        if (n >= 3) MEMORY[3] = 4;

        for (int i = 4; i <= n; i++) {
            MEMORY[i] = (MEMORY[i - 1] + MEMORY[i - 2] + MEMORY[i - 3]) % 1000;
        }

        System.out.println(MEMORY[n]);
        br.close();
    }
}
