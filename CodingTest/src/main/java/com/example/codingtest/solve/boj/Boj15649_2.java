package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15649_2 {
    static StringBuilder SB = new StringBuilder();
    static int N;
    static int M;
    static int[] ARR;
    static boolean[] VISITED;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ARR = new int[M];
        VISITED = new boolean[N + 1];

        dfs(0);

        System.out.println(SB);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int num : ARR) {
                SB.append(num).append(" ");
            }
            SB.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                ARR[depth] = i;
                dfs(depth + 1);
                VISITED[i] = false;
            }
        }
    }

}
