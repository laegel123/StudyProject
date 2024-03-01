package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11403 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        boolean[] visited;
        int[][] info = new int[N][N];
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, info, visited);

            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    result[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void dfs(int start, int[][] info, boolean[] visited) {

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            if (info[start][i] == 1) {
                visited[i] = true;
                dfs(i, info, visited);
            }
        }

    }
}
