package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup2652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(recur(n, k));
        br.close();
    }

    static int recur(int n, int k) {
        if (k == 0) return 1;
        if (k < 0) return 0;
        if (n <= 0) return 0;


        return recur(n - 2, k - 1) + recur(n - 1, k);
    }

}
