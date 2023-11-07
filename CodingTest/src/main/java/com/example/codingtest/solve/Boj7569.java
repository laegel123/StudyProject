package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {

    static int N;
    static int M;
    static int H;
    static int[][][] ARR;
    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};
    static int[] DISTANCE_H = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ARR = new int[H][N][M];

        int notRipenCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                int index = 0;
                while (st.hasMoreTokens()) {
                    ARR[h][x][index] = Integer.parseInt(st.nextToken());

                    if (ARR[h][x][index] == 1) {
                        queue.add(new int[]{h, x, index});
                    }

                    if (ARR[h][x][index] == 0) {
                        notRipenCount++;
                    }

                    index++;
                }
            }
        }


        if (notRipenCount == 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs(queue, notRipenCount));
        }

        br.close();
    }

    static int bfs(Queue<int[]> queue, int notRipenCount) {
        int daysCount = -1;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            daysCount++;

            for (int day = 0; day < qSize; day++) {
                int[] now = queue.poll();

                for (int i = 0; i < 2; i++) {
                    int newH = now[0] + DISTANCE_H[i];

                    if (newH < 0 || newH >= H) {
                        continue;
                    }

                    if (ARR[newH][now[1]][now[2]] == 0) {
                        ARR[newH][now[1]][now[2]] = 1;
                        notRipenCount--;

                        queue.add(new int[]{newH, now[1], now[2]});
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int newX = now[1] + DISTANCE_X[i];
                    int newY = now[2] + DISTANCE_Y[i];

                    if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
                        continue;
                    }

                    if (ARR[now[0]][newX][newY] == 0) {
                        ARR[now[0]][newX][newY] = 1;
                        notRipenCount--;

                        queue.add(new int[]{now[0], newX, newY});
                    }
                }
            }
        }

        if (notRipenCount > 0) {
            return -1;
        } else {
            return daysCount;
        }
    }
}
