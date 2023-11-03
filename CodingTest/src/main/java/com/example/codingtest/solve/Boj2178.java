package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {

    static int N;
    static int M;
    static int[][] ARR;

    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};

    static boolean[][] VISITED;
    static int[][] COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ARR = new int[N][M];
        VISITED = new boolean[N][M];
        COUNT = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");

            for (int j = 0; j < str.length; j++) {
                ARR[i][j] = Integer.parseInt(str[j]);
            }
        }

        bfs(0, 0);

        System.out.println(COUNT[N - 1][M - 1] + 1);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        VISITED[x][y] = true;

        while (!queue.isEmpty()) {
            int[] nowLocation = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = nowLocation[0] + DISTANCE_X[i];
                int newY = nowLocation[1] + DISTANCE_Y[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) {
                    continue;
                }

                int[] newLocation = new int[]{newX, newY};

                if (!VISITED[newX][newY] && ARR[newX][newY] != 0) {
                    queue.add(newLocation);
                    VISITED[newX][newY] = true;
                    COUNT[newX][newY] = COUNT[nowLocation[0]][nowLocation[1]] + 1;
                }
            }
        }
    }
}
