package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10974 {
    static int N;
    static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ARR = new int[N];
        for (int i = 0; i < N; i++) {
            ARR[i] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(i + 1).append(" ");
        }

        System.out.println(sb);

        while (getNextPermutation()) {
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(ARR[i]).append(" ");
            }

            System.out.println(sb);
        }
    }

    static boolean getNextPermutation() {
        int i = N - 1;
        while (i > 0 && ARR[i - 1] >= ARR[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = N - 1;
        while (ARR[i - 1] >= ARR[j]) {
            j--;
        }

        swap(i - 1, j);

        j = N - 1;
        while (j > i) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    static void swap(int i, int j) {
        int tmp = ARR[i];
        ARR[i] = ARR[j];
        ARR[j] = tmp;
    }
}
