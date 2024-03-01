package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15661 {
    static int N;
    static int[][] ARR;
    static boolean[] VISITED;
    static int MIN_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ARR = new int[N][N];
        VISITED = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(MIN_VALUE);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == N) {
            getScore();

            if (MIN_VALUE == 0) {
                System.out.println(MIN_VALUE);
                System.exit(0);
            }
            return;
        }

        VISITED[depth] = true;
        dfs(depth + 1);
        VISITED[depth] = false;
        dfs(depth + 1);
    }

    static void getScore() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (VISITED[i] && VISITED[j]) {
                    teamA += (ARR[i][j] + ARR[j][i]);
                }

                if (!VISITED[i] && !VISITED[j]) {
                    teamB += (ARR[i][j] + ARR[j][i]);
                }
            }
        }

        MIN_VALUE = Math.min(MIN_VALUE, Math.abs(teamA - teamB));
    }

}
