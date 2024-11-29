package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeup1901 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        recur(1);

        br.close();

    }


    static void recur(int n) {
        if (n > N) return;

        System.out.println(n);
        recur(n + 1);

    }

}