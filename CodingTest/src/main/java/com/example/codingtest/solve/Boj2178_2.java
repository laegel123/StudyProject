package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178_2 {
    static int N, M;
    static int[][] MAZE;
    static boolean[][] VISITED;

    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAZE = new int[N + 1][M + 1];
        VISITED = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                MAZE[i][j + 1] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs();

        System.out.println(MAZE[N][M]);
        br.close();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        VISITED[1][1] = true;

        while (!queue.isEmpty()) {
            int[] currentPlace = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentPlace[0] + DISTANCE_X[i];
                int nextY = currentPlace[1] + DISTANCE_Y[i];

                if (nextX < 1 || nextY < 1 || nextX > N || nextY > M) {
                    continue;
                }

                if (MAZE[nextX][nextY] != 0 && !VISITED[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    MAZE[nextX][nextY] = MAZE[currentPlace[0]][currentPlace[1]] + 1;
                    VISITED[nextX][nextY] = true;
                }
            }
        }

    }

}
