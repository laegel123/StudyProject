package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178_2 {
    static int[][] MAZE;
    static boolean[][] VISITED;
    static int N;
    static int M;
    static int[] DISTANCE_X = {0, 1, 0, -1};
    static int[] DISTANCE_Y = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAZE = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                MAZE[i][j] = Integer.parseInt(split[j]);
            }
        }

        bfs();
        System.out.println(MAZE[N - 1][M - 1]);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        VISITED[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + DISTANCE_X[i];
                int newY = now[1] + DISTANCE_Y[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) {
                    continue;
                }

                if (MAZE[newX][newY] > 0 && !VISITED[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    VISITED[newX][newY] = true;
                    MAZE[newX][newY] = MAZE[now[0]][now[1]] + 1;

                    if (newX == N - 1 && newY == M - 1) {
                        return;
                    }
                }
            }
        }
    }

}
