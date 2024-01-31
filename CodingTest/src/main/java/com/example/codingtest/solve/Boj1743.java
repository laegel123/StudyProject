package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1743 {
    static int N, M, K;
    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};
    static int MAX_COUNT = Integer.MIN_VALUE;
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 1][M + 1];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                COUNT = 0;
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(map, visited, i, j);
                }

                MAX_COUNT = Math.max(MAX_COUNT, COUNT);
            }
        }


        System.out.println(MAX_COUNT);
        br.close();

    }

    static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        COUNT++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DISTANCE_X[i];
            int nextY = y + DISTANCE_Y[i];

            if (nextX < 1 || nextY < 1 || nextX > N || nextY > M) {
                continue;
            }

            if (!visited[nextX][nextY] && map[nextX][nextY] > 0) {
                dfs(map, visited, nextX, nextY);
            }
        }
    }
}
