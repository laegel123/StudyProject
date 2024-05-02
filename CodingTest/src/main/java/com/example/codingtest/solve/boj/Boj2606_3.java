package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2606_3 {
    static int N;
    static int K;
    static int[][] MAP;
    static boolean[] VISITED;
    static int COUNT = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        MAP = new int[N + 1][N + 1];
        VISITED = new boolean[N + 1];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            MAP[x][y] = 1;
            MAP[y][x] = 1;
        }


        dfs(1);
        System.out.println(COUNT - 1);
        br.close();
    }

    static void dfs(int start) {
        VISITED[start] = true;
        COUNT++;
        for (int i = 1; i < N + 1; i++) {
            if (!VISITED[i] && MAP[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
