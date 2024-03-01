package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10972 {
    static int N;
    static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ARR = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();
        if (getNextPermutation()) {
            for (int i = 0; i < N; i++) {
                sb.append(ARR[i]).append(" ");
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
        br.close();
    }

    static boolean getNextPermutation() {
        int i = N - 1;
        while (i > 0 && ARR[i - 1] > ARR[i]) {
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
            j--;
            i++;
        }

        return true;
    }

    static void swap(int i, int j) {
        int tmp = ARR[i];
        ARR[i] = ARR[j];
        ARR[j] = tmp;
    }
}
