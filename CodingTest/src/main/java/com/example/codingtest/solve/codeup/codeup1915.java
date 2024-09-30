package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-09-30
 */
public class codeup1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
        br.close();
    }

    public static int fibo(int x) {
        if (x == 1) return 1;
        if (x == 2) return 1;

        return fibo(x - 1) + fibo(x - 2);
    }
}
