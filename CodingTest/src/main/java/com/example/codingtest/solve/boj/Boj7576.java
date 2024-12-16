package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
    static int N;
    static int M;
    static boolean[][] VISITED;
    static int[][] MAP;
    static int[] DISTANCE_X = {1, -1, 0, 0};
    static int[] DISTANCE_Y = {0, 0, 1, -1};
    static Queue<int[]> QUEUE = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        VISITED = new boolean[M][N];
        MAP = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] == 1) {
                    QUEUE.add(new int[]{i, j});
                    VISITED[i][j] = true;
                }
            }
        }

        bfs();

        int day = 0;
        boolean im = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (MAP[i][j] == 0) {
                    im = true;
                } else {
                    day = Math.max(day, MAP[i][j]);
                }
            }
        }

        System.out.println(im ? -1 : day - 1);
        br.close();
    }

    static void bfs() {
        while (!QUEUE.isEmpty()) {
            int[] now = QUEUE.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + DISTANCE_X[i];
                int nextY = now[1] + DISTANCE_Y[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;

                if (!VISITED[nextX][nextY] && MAP[nextX][nextY] == 0) {
                    QUEUE.add(new int[]{nextX, nextY});
                    MAP[nextX][nextY] = MAP[now[0]][now[1]] + 1;
                    VISITED[nextX][nextY] = true;
                }
            }
        }
    }

}
