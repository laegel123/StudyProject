package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569_2 {
    static int N;
    static int M;
    static int H;
    static int[][][] MAP;
    static Queue<int[]> QUEUE = new LinkedList<>();
    static boolean[][][] VISITED;
    static int[] DISTANCE_X = {1, -1, 0, 0};
    static int[] DISTANCE_Y = {0, 0, 1, -1};
    static int[] DISTANCE_H = {1, -1};
    static int UNRIPE_COUNT = 0;
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        MAP = new int[H][N][M];
        VISITED = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int z = 0; z < M; z++) {
                    MAP[i][j][z] = Integer.parseInt(st.nextToken());

                    if (MAP[i][j][z] == 1) {
                        QUEUE.offer(new int[]{i, j, z});
                    }

                    if (MAP[i][j][z] == 0) {
                        UNRIPE_COUNT++;
                    }
                }
            }
        }

        bfs();
        if (UNRIPE_COUNT != 0) {
            System.out.println(-1);
        } else {
            System.out.println(COUNT - 1);
        }

        br.close();
    }

    static void bfs() {
        while (!QUEUE.isEmpty()) {
            int[] nowPosition = QUEUE.poll();
            COUNT = Math.max(COUNT, MAP[nowPosition[0]][nowPosition[1]][nowPosition[2]]);

            for (int i = 0; i < 2; i++) {
                int newH = nowPosition[0] + DISTANCE_H[i];

                if (newH < 0 || newH >= H) {
                    continue;
                }

                if (!VISITED[newH][nowPosition[1]][nowPosition[2]] && MAP[newH][nowPosition[1]][nowPosition[2]] == 0) {
                    VISITED[newH][nowPosition[1]][nowPosition[2]] = true;
                    UNRIPE_COUNT--;
                    MAP[newH][nowPosition[1]][nowPosition[2]] = MAP[nowPosition[0]][nowPosition[1]][nowPosition[2]] + 1;
                    QUEUE.offer(new int[]{newH, nowPosition[1], nowPosition[2]});
                }
            }

            for (int i = 0; i < 4; i++) {
                int newN = nowPosition[1] + DISTANCE_X[i];
                int newM = nowPosition[2] + DISTANCE_Y[i];

                if (newN < 0 || newN >= N || newM < 0 || newM >= M) {
                    continue;
                }

                if (!VISITED[nowPosition[0]][newN][newM] && MAP[nowPosition[0]][newN][newM] == 0) {
                    VISITED[nowPosition[0]][newN][newM] = true;
                    UNRIPE_COUNT--;
                    MAP[nowPosition[0]][newN][newM] = MAP[nowPosition[0]][nowPosition[1]][nowPosition[2]] + 1;
                    QUEUE.offer(new int[]{nowPosition[0], newN, newM});
                }
            }


        }
    }











}
