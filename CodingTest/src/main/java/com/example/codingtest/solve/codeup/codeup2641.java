package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeup2641 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(countWays(n, 0, 0));
        br.close();
    }

    static int countWays(int n, int current, int count) {
        if (current == n) return 1;
        if (current > n) return 0;

        int way = 0;
        way += countWays(n, current + 1, Math.max(0, count - 1));
        way += countWays(n, current + 2, Math.max(0, count - 1));

        if (count == 0) {
            way += countWays(n, current + 3, 2);
        }

        return way;
    }

}
