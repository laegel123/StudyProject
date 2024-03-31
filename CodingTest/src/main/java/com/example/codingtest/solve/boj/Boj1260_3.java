package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260_3 {

    static int[][] MAP;
    static boolean[] VISITED;
    static int N;
    static int M;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        MAP = new int[N + 1][N + 1];
        VISITED = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            MAP[x][y] = 1;
            MAP[y][x] = 1;
        }

        dfs(start);
        VISITED = new boolean[N + 1];
        SB.append("\n");
        bfs(start);

        System.out.println(SB);
    }

    static void dfs(int start) {
        VISITED[start] = true;
        SB.append(start).append(" ");

        for (int i = 1; i < N + 1; i++) {
            if (MAP[start][i] == 1 && !VISITED[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        VISITED[start] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            SB.append(num).append(" ");

            for (int i = 1; i < N + 1; i++) {
                if (MAP[num][i] == 1 && !VISITED[i]) {
                    queue.add(i);
                    VISITED[i] = true;
                }
            }

        }
    }


}













