package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260 {
    static int N;
    static int M;
    static int V;
    static int[][] ARR;
    static boolean[] VISITED;
    static StringBuilder SB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        ARR = new int[N + 1][N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            ARR[i][j] = 1;
            ARR[j][i] = 1;
        }

        VISITED = new boolean[N + 1];
        SB = new StringBuilder();
        dfs(V, 0);

        SB.append("\n");
        VISITED = new boolean[N + 1];
        bfs(V);
        System.out.println(SB);
        br.close();
    }

    static void dfs(int x, int depth) {
        SB.append(x).append(" ");
        VISITED[x] = true;

        if (depth == N) {
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (ARR[x][i] == 1 && !VISITED[i]) {
                dfs(i, depth++);
            }

        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        VISITED[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            SB.append(now).append(" ");

            for (int i = 1; i < N + 1; i++) {
                if (!VISITED[i] && ARR[now][i] == 1) {
                    queue.add(i);
                    VISITED[i] = true;
                }
            }
        }
    }


}
