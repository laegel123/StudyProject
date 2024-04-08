package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3109 {
    static int[] DISTANCE_X = {-1, 0, 1};
    static int[] DISTANCE_Y = {1, 1, 1};
    static int N;
    static int M;
    static char[][] MAP;
    static boolean[][] VISITED;
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new char[N][M];
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

    public static boolean dfs(int x, int y) {
        VISITED[x][y] = true;

        for (int i = 0; i < 3; i++) {
            int newX = x + DISTANCE_X[i];
            int newY = y + DISTANCE_Y[i];

            if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
                continue;
            }

            if (MAP[newX][newY] == '.' && !VISITED[newX][newY]) {
                VISITED[newX][newY] = true;
                if (newY == M - 1) {
                    COUNT++;
                    return true;
                }

                if (dfs(newX, newY)) {
                    return true;
                }
            }
        }

        return false;
    }
}
