package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj9663 {
    static int N;
    static int[] ARR;
    static int COUNT = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ARR = new int[N];

        recur(0);

        System.out.println(COUNT);
        br.close();
    }

    static void recur(int depth) {
        if (depth == N) {
            COUNT++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(depth, i)) {
                ARR[depth] = i;
                recur(depth + 1);
            }
        }
    }

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (ARR[i] == col || Math.abs(ARR[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
