package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18185_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ramens = new int[n];
        for (int i = 0; i < n; i++) {
            ramens[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int x = ramens[i];
            answer += 3 * x;
            ramens[i] -= x;

            if (i + 1 < n) {
                x = Math.min(x, ramens[i + 1]);
                answer += 2 * x;
                ramens[i + 1] -= x;
            }

            if (i + 2 < n) {
                x = Math.min(x, ramens[i + 2] - Math.min(ramens[i + 1], ramens[i + 2]));
                answer += 2 * x;
                ramens[i + 2] -= x;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
