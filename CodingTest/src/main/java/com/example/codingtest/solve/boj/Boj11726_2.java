package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11726_2 {
    static int[] ARR = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ARR[0] = 1;
        ARR[1] = 1;
        ARR[2] = 2;
        ARR[3] = 3;
        ARR[4] = 5;

        System.out.println(fibo(n));
        br.close();
    }

    static int fibo(int n) {
        if (ARR[n] != 0 ) {
            return ARR[n];
        }

        ARR[n] = fibo(n - 1) + fibo(n - 2);
        ARR[n] %= 10007;
        return ARR[n];
    }
}
