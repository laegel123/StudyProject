package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj18290 {
    static int N;
    static int M;
    static int K;
    static int[][] ARR;
    static int[] MEMORY;
    static int MAX_SUM = Integer.MIN_VALUE;
    static List<int[]> VISITED = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ARR = new int[N][M];
        MEMORY = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(MAX_SUM);
        br.close();
    }

    static boolean isAdjectNode(int x, int y) {
        boolean flag = false;

        for (int i = 0; i < VISITED.size(); i++) {
            if ((VISITED.get(i)[0] - 1 == x && VISITED.get(i)[1] == y)
                    || (VISITED.get(i)[0] + 1 == x && VISITED.get(i)[1] == y)
                    || (VISITED.get(i)[0] == x && VISITED.get(i)[1] - 1 == y)
                    || (VISITED.get(i)[0] == x && VISITED.get(i)[1] + 1 == y)
                    || (VISITED.get(i)[0] == x && VISITED.get(i)[1] == y)) {
                flag = true;
            }
        }

        return flag;
    }

    static void dfs(int depth) {
        if (K == depth) {
            int sum = 0;
            for (int val : MEMORY) {
                sum += val;
            }

            MAX_SUM = Math.max(MAX_SUM, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isAdjectNode(i, j)) {
                    VISITED.add(new int[]{i, j});
                    MEMORY[depth] = ARR[i][j];
                    dfs(depth + 1);
                    VISITED.remove(depth);
                }
            }
        }
    }
}
