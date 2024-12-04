package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeup1916_2 {
    static int[] ARR;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ARR = new int[n + 1];

        System.out.println(recur(n));

        br.close();
    }

    static int recur(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (ARR[n] != 0) return ARR[n];
        return ARR[n] = (recur(n - 1) + recur(n - 2)) % 10009;
    }

}
