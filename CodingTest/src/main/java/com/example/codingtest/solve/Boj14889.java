package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14889 {
    static int N;
    static int[][] SCORE;
    static boolean[] VISITED;
    static int MIN_SCORE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        SCORE = new int[N][N];
        VISITED = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                SCORE[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(MIN_SCORE);
        br.close();
    }

    static void dfs(int x, int depth) {
        if (depth == N / 2) {
            getScore();

            return;
        }

        for (int i = x; i < N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                dfs(i + 1, depth + 1);
                VISITED[i] = false;
            }
        }
    }

    static void getScore() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (VISITED[i] && VISITED[j]) {
                    teamA += SCORE[i][j];
                }
                if (!VISITED[i] && !VISITED[j]) {
                    teamB += SCORE[i][j];
                }
            }
        }

        MIN_SCORE = Math.min(MIN_SCORE, Math.abs(teamA - teamB));
    }

}
