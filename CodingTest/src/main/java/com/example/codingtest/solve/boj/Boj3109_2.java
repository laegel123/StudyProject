package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3109_2 {
    static int[] DISTANCE_X = {-1, 0, 1};
    static int[] DISTANCE_Y = {1, 1, 1};
    static int N;
    static int M;
    static boolean[][] VISITED;
    static int[][] MAP;
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(COUNT);
        br.close();
    }

    static boolean dfs(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int nextX = x + DISTANCE_X[i];
            int nextY = y + DISTANCE_Y[i];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                continue;
            }

            if (!VISITED[nextX][nextY] && MAP[nextX][nextY] == '.') {
                VISITED[nextX][nextY] = true;
                if (nextY == M - 1) {
                    COUNT++;
                    return true;
                }

                if (dfs(nextX, nextY)) {
                    return true;
                }
            }
        }

        return false;
    }
}
