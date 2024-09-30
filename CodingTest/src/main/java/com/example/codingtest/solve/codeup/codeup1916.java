package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-09-30
 */
public class codeup1916 {
    static int[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memory = new int[n + 1];
        memory[1] = 1;
        if (n >= 2) {
            memory[2] = 1;
        }

        System.out.println(fibo(n));
        br.close();
    }

    public static int fibo(int x) {
        if (memory[x] == 0) {
            memory[x] = (fibo(x - 1) + fibo(x - 2)) % 10009;
        }

        return memory[x];
    }
}
