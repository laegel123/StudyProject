package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260_2 {
    static StringBuilder SB = new StringBuilder();
    static int N, M, V;
    static int[][] NODE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        NODE = new int[N + 1][N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            NODE[a][b] = 1;
            NODE[b][a] = 1;
        }


        boolean[] visited = new boolean[N + 1];
        dfs(V, visited);
        SB.append("\n");
        visited = new boolean[N + 1];
        bfs(V, visited);

        System.out.println(SB);
        br.close();
    }

    static void dfs(int v, boolean[] visited) {
        SB.append(v + " ");
        visited[v] = true;

        for (int i = 1; i < N + 1; i++) {
            if (NODE[v][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    static void bfs(int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            SB.append(node + " ");

            for (int i = 1; i < N + 1; i++) {
                if (NODE[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
