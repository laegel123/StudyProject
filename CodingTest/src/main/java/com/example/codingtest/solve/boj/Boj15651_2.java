package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15651_2 {
    static int N;
    static int M;
    static int[] ARR;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ARR = new int[M];

        dfs(0);

        System.out.println(SB);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i : ARR) {
                SB.append(i).append(" ");
            }

            SB.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            ARR[depth] = i;
            dfs(depth + 1);
        }
    }

}
