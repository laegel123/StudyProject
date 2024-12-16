package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178_4 {
    static int N;
    static int M;
    static int[][] VISITED;
    static int[][] ARR;
    static int[] DISTANCE_X = {1, -1, 0, 0};
    static int[] DISTANCE_Y = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ARR = new int[N][M];
        VISITED = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                ARR[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
        br.close();
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        VISITED[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == N - 1 && now[1] == M - 1) break;

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + DISTANCE_X[i];
                int nextY = now[1] + DISTANCE_Y[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                if (ARR[nextX][nextY] == 1 && VISITED[nextX][nextY] == 0) {
                    VISITED[nextX][nextY] = VISITED[now[0]][now[1]] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return VISITED[N - 1][M - 1];
    }

}
