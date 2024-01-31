package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10026 {
    static int N;
    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int normalCount = 0;
        boolean[][] visited = new boolean[N][N];
        int cwCount = 0;
        boolean[][] cwVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(map, visited, i, j, map[i][j], false);
                    normalCount++;
                }

                if (!cwVisited[i][j]) {
                    dfs(map, cwVisited, i, j, map[i][j], true);
                    cwCount++;
                }
            }
        }

        System.out.println(normalCount + " " + cwCount);
        br.close();
    }

    static void dfs(char[][] map, boolean[][] visited, int x, int y, char c, boolean isColorWeekness) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DISTANCE_X[i];
            int nextY = y + DISTANCE_Y[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[nextX][nextY]) {
                continue;
            }

            if (!isColorWeekness) {
                if (c == map[nextX][nextY]) {
                    dfs(map, visited, nextX, nextY, c, isColorWeekness);
                }
            } else {
                if (c == 'B') {
                    if (map[nextX][nextY] == 'B') {
                        dfs(map, visited, nextX, nextY, c, isColorWeekness);
                    }
                } else {
                    if (map[nextX][nextY] != 'B') {
                        dfs(map, visited, nextX, nextY, c, isColorWeekness);
                    }
                }
            }
        }
    }
}
