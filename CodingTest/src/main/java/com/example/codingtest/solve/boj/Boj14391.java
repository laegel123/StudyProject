package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14391 {
    static int N;
    static int M;
    static int[][] ARR;
    static boolean[][] VISITED;
    static int MAX_SUM = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ARR = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                ARR[i][j] = Integer.parseInt(str[j]);
            }
        }

        dfs(0, 0, 0);

        System.out.println(MAX_SUM);
        br.close();
    }

    static void dfs(int depth, int num, int sum) {
        if (depth == N * M) {
            MAX_SUM = Math.max(MAX_SUM, sum);
            return;
        }

        int x = depth / M;
        int y = depth % M;

        if (VISITED[x][y]) {
            dfs(depth + 1, num, sum);
        } else {
            VISITED[x][y] = true;
            num = num * 10 + ARR[x][y];
            dfs(depth + 1, 0, sum + num);

            int i, temp = num;
            for (i = x + 1; i < N; i++) {
                if (VISITED[i][y]) {
                    break;
                }

                VISITED[i][y] = true;
                temp = temp * 10 + ARR[i][y];
                dfs(depth + 1, 0, sum + temp);
            }

            // 초기화
            for (int j = x + 1; j < i; j++) {
                VISITED[j][y] = false;
            }
            temp = num;

            for (i = y + 1; i < M; i++) {
                if (VISITED[x][i]) {
                    break;
                }

                VISITED[x][i] = true;
                temp = temp * 10 + ARR[x][i];
                dfs(depth + i - y + 1, 0, sum + temp);
            }

            for (int j = y + 1; j < i; j++) {
                VISITED[x][j] = false;
            }

            VISITED[x][y] = false;
        }

    }
}
