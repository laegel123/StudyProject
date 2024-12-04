package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeup2625 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                for (int c = 1; c < n; c++) {
                    if (a >= b && b >= c && a < b + c && a + b + c == n) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
        br.close();
    }

}
