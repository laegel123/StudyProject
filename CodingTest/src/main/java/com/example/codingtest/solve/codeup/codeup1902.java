package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeup1902 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        recur(n);

        br.close();
    }

    static void recur(int n) {
        if (n <= 0) return;
        System.out.println(n);
        recur(n-1);
    }

}
