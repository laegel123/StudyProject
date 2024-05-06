package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2468_2 {
    static int N;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int[] DISTANCE_X = {1, -1, 0, 0};
    static int[] DISTANCE_Y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        VISITED = new boolean[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] > maxHeight) {
                    maxHeight = MAP[i][j];
                }
            }
        }

        int maxCount = 0;
        for (int z = 0; z < maxHeight + 1; z++) {
            int count = 0;
            VISITED = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!VISITED[i][j] && MAP[i][j] > z) {
                        dfs(i, j, z);
                        count++;
                    }
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
        br.close();
    }

    static void dfs(int x, int y, int length) {
        for (int i = 0; i < 4; i++) {
            int newX = x + DISTANCE_X[i];
            int newY = y + DISTANCE_Y[i];

            if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                continue;
            }

            if (!VISITED[newX][newY] && MAP[newX][newY] > length) {
                VISITED[newX][newY] = true;
                dfs(newX, newY, length);
            }

        }
    }
}
