package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj6803 {
    static int N = 1;
    static int[] ARR;
    static List<Integer> MEMORIES;
    static boolean[] VISITED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            ARR = new int[N];
            MEMORIES = new ArrayList<>();
            VISITED = new boolean[N];

            for (int i = 0; i < N; i++) {
                ARR[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0);

            SB.append("\n");
        }

        System.out.println(SB);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == 6) {
            MEMORIES.forEach(m -> {
                SB.append(m).append(" ");
            });
            SB.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (VISITED[i]) {
                continue;
            }

            if (MEMORIES.size() != 0 && MEMORIES.get(MEMORIES.size() - 1) > ARR[i]) {
                continue;
            }

            VISITED[i] = true;
            MEMORIES.add(ARR[i]);
            dfs(depth + 1);
            MEMORIES.remove(MEMORIES.size() - 1);
            VISITED[i] = false;

        }
    }
}
