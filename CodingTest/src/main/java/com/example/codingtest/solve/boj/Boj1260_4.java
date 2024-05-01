package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260_4 {
    static int N;
    static int M;
    static int K;
    static int[][] MAP;
    static boolean[] VISITED;
    static StringBuilder SB = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        MAP = new int[N + 1][N + 1];
        VISITED = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            MAP[x][y] = 1;
            MAP[y][x] = 1;
        }

        dfs(K);
        SB.append("\n");
        VISITED = new boolean[N + 1];
        bfs(K);

        System.out.println(SB);
        br.close();
    }

    static void dfs(int x) {
        VISITED[x] = true;
        SB.append(x).append(" ");
        for (int i = 1; i < N + 1; i++) {
            if (!VISITED[i] && MAP[x][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        VISITED[x] = true;

        while (!queue.isEmpty()) {
            int nowX = queue.poll();
            SB.append(nowX).append(" ");

            for (int i = 1; i < N + 1; i++) {
                if (!VISITED[i] && MAP[nowX][i] == 1) {
                    queue.offer(i);
                    VISITED[i] = true;
                }
            }
        }
    }


}
