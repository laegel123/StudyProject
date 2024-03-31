package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2606_2 {
    static int COUNT = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        int[][] connect = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            connect[x][y] = 1;
            connect[y][x] = 1;
        }

        dfs(connect, visited, 1);
        System.out.println(COUNT);
    }

    static void dfs(int[][] connect, boolean[] visited, int virus) {
        visited[virus] = true;

        for (int i = 1; i < N + 1; i++) {
            if (connect[virus][i] == 1 && !visited[i]) {
                COUNT++;
                dfs(connect, visited, i);
            }
        }
    }
}
