package com.example.codingtest.solve.boj;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-05-07
 */
public class Boj2573 {
    static int N;
    static int M;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int[] DISTANCE_X = {1, -1, 0, 0};
    static int[] DISTANCE_Y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int yearCount = 0;
        while (true) {
            VISITED = new boolean[N][M];
            int islandCount = islandCount();
            if (islandCount >= 2) {
                System.out.println(yearCount);
                break;
            } else if (islandCount == 0) {
                System.out.println(0);
                break;
            }

            bfs();
            yearCount++;
        }
    }

    static int islandCount() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!VISITED[i][j] && MAP[i][j] > 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + DISTANCE_X[i];
            int nextY = y + DISTANCE_Y[i];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                continue;
            }

            if (!VISITED[nextX][nextY] && MAP[nextX][nextY] > 0) {
                VISITED[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        VISITED = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] > 0) {
                    VISITED[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + DISTANCE_X[i];
                int nextY = now[1] + DISTANCE_Y[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if (!VISITED[nextX][nextY] && MAP[nextX][nextY] == 0) {
                    if (MAP[now[0]][now[1]] > 0) {
                        MAP[now[0]][now[1]]--;
                    }
                }
            }
        }
    }
}
