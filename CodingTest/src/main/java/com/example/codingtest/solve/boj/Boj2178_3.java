package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178_3 {
    static int[] DISTANCE_X = {1, -1, 0, 0};
    static int[] DISTANCE_Y = {0, 0, 1, -1};
    static int[][] MAP;
    static boolean[][] VISITED;
    static int N;
    static int M;
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
                MAP[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs();

        System.out.println(MAP[N - 1][M - 1]);
        br.close();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        VISITED[0][0] = true;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            if (position[0] == N && position[1] == M) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = position[0] + DISTANCE_X[i];
                int nextY = position[1] + DISTANCE_Y[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }
                if (!VISITED[nextX][nextY] && MAP[nextX][nextY] == 1) {
                    MAP[nextX][nextY] = MAP[position[0]][position[1]] + 1;
                    queue.offer(new int[]{nextX, nextY});
                    VISITED[nextX][nextY] = true;
                }
            }
        }
    }
}
