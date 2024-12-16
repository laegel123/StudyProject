package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1926 {
    static boolean[][] VISITED;
    static int[][] ARR;
    static int[] DISTANCE_X = {1, -1, 0, 0};
    static int[] DISTANCE_Y = {0, 0, -1, 1};
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ARR = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxWidth = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ARR[i][j] == 1 && !VISITED[i][j]) {
                    count++;
                    maxWidth = Math.max(maxWidth, bfs(i, j));
                }
            }
        }

        System.out.println(count);
        System.out.println(maxWidth);

        br.close();
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        VISITED[x][y] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + DISTANCE_X[i];
                int newY = now[1] + DISTANCE_Y[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;

                if (ARR[newX][newY] == 1 && !VISITED[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    VISITED[newX][newY] = true;
                    count++;
                }

            }
        }

        return count;
    }

}
