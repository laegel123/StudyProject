package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10819 {
    static int N;
    static int[] ARR;
    static int[] MEMORIES;
    static boolean[] VISITED;
    static int MAX_SUM = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ARR = new int[N];
        MEMORIES = new int[N];
        VISITED = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(MAX_SUM);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(MEMORIES[i] - MEMORIES[i + 1]);
            }

            MAX_SUM = Math.max(MAX_SUM, sum);
        }

        for (int i = 0; i < N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                MEMORIES[depth] = ARR[i];
                dfs(depth + 1);
                VISITED[i] = false;
            }
        }
    }
}
