package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeup1912 {
    static int N = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        recur(n);
        System.out.println(N);

        br.close();
    }

    static void recur(int n) {
        if (n <= 0) return;
        N *= n;
        recur(n - 1);
    }

}
