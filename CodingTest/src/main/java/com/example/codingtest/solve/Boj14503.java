package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14503 {
    static int N, M, R, C, D;
    static int[][] BOARD;
    static int COUNT = 0;
    static int[] DX = {-1, 0, 1, 0};
    static int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        BOARD = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                BOARD[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(R, C, D);

        System.out.println(COUNT);
        br.close();
    }

    static void dfs(int x, int y, int direct) {
        if (BOARD[x][y] == 0) {
            COUNT++;
            BOARD[x][y] = 2;
        }

        for (int i = 0; i < 4; i++) {
            direct = (direct + 3) % 4;
            int newX = x + DX[direct];
            int newY = y + DY[direct];

            if (newX >= 0 && newY >= 0 && newX < N && newY < M && BOARD[newX][newY] == 0) {
                dfs(newX, newY, direct);

                return;
            }
        }

        int behind = (direct + 2) % 4;
        int newX = x + DX[behind];
        int newY = y + DY[behind];

        if (newX >= 0 && newX < N && newY >= 0 && newY < M && BOARD[newX][newY] != 1) {
            dfs(newX, newY, direct);
        }

    }


}
