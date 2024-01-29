package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012 {
    static StringBuilder SB = new StringBuilder();
    static int[] DISTANCE_X = {0, 1, 0, -1};
    static int[] DISTANCE_Y = {1, 0, -1, 0};

    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int[][] info = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                info[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && info[i][j] == 1) {
                        bfs(info, visited, j, i);
                        count++;
                    }
                }
            }

            SB.append(count).append("\n");
        }

        System.out.println(SB);
        br.close();
    }

    static void bfs(int[][] info, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] nextInfo = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newY = nextInfo[0] + DISTANCE_Y[i];
                int newX = nextInfo[1] + DISTANCE_X[i];

                if (newX < 0 || newX >= M || newY < 0 || newY >= N) {
                    continue;
                }

                if (!visited[newY][newX] && info[newY][newX] == 1) {
                    queue.add(new int[]{newY, newX});
                    visited[newY][newX] = true;
                }
            }
        }
    }
}
