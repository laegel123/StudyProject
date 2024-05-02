package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-05-02
 */
public class Boj2667_2 {
    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};
    static int N;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int TOTAL_COUNT = 0;
    static int COUNT = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        VISITED = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                COUNT = 0;
                if (!VISITED[i][j] && MAP[i][j] == 1) {
                    TOTAL_COUNT++;
                    dfs(i, j);
                    list.add(COUNT);
                }
            }
        }

        Collections.sort(list);

        System.out.println(TOTAL_COUNT);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        br.close();
    }

    static void dfs(int x, int y) {
        VISITED[x][y] = true;
        COUNT++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + DISTANCE_X[i];
            int nextY = y + DISTANCE_Y[i];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                continue;
            }

            if (!VISITED[nextX][nextY] && MAP[nextX][nextY] == 1) {
                dfs(nextX, nextY);
            }

        }
    }
}
