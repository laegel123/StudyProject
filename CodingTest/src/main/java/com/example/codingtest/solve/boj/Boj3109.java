package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-04-06
 */
public class Boj3109 {
    static int[] DISTANCE_X = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] DISTANCE_Y = {1, 0, -1, 0, 1, -1, 1, -1};
    static boolean[][] VISITED;
    static char[][] MAP;
    static int COUNT = 0;
    static int N;
    static int M;

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

        dfs(0, 0);

        System.out.println(COUNT);
        br.close();
    }

    public static void dfs(int x, int y) {
        VISITED[x][y] = true;

        if (x == N - 1 && y == M - 1) {
            COUNT++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + DISTANCE_X[i];
            int newY = y + DISTANCE_Y[i];

            if (newX < 0 || newY < 0 || newX >= N || newY >= M) {
                return;
            }

            if (!VISITED[newX][newY] && MAP[newX][newY] == '.') {
                dfs(newX, newY);
                VISITED[newX][newY] = false;
            }
        }
    }


}
