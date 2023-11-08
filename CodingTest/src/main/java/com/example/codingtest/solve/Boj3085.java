package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj3085 {

    static int N;
    static int[] DISTANCE_X = {1, 0};
    static int[] DISTANCE_Y = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] candyArr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                candyArr[i][j] = str.charAt(j);
            }
        }

        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxCount = Math.max(maxCount, swapCandy(i, j, candyArr));
            }
        }

        System.out.println(maxCount);
    }

    static int swapCandy(int x, int y, char[][] candyArr) {
        int maxCount = 0;

        for (int i = 0; i < 2; i++) {
            int nextX = x + DISTANCE_X[i];
            int nextY = y + DISTANCE_Y[i];

            if (nextX >= N || nextY >= N || candyArr[x][y] == candyArr[nextX][nextY]) {
                continue;
            }

            char[][] copyArr = new char[N][N];

            for (int j = 0; j < N; j++) {
                copyArr[j] = candyArr[j].clone();
            }

            copyArr[nextX][nextY] = candyArr[x][y];
            copyArr[x][y] = candyArr[nextX][nextY];

            maxCount = Math.max(maxCount, getCandyCount(copyArr));
        }

        return maxCount;
    }

    static int getCandyCount(char[][] candyArr) {
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            char nowX = candyArr[i][0];
            int countX = 1;

            char nowY = candyArr[0][i];
            int countY = 1;

            for (int j = 1; j < N; j++) {
                if (nowX == candyArr[i][j]) {
                    countX++;
                } else {
                    nowX = candyArr[i][j];
                    countX = 1;
                }
                maxCount = Math.max(maxCount, countX);

                if (nowY == candyArr[j][i]) {
                    countY++;
                } else {
                    nowY = candyArr[j][i];
                    countY = 1;
                }

                maxCount = Math.max(maxCount, countY);
            }
        }

        return maxCount;
    }
}
