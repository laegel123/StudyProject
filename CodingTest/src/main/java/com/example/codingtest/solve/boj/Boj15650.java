package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15650 {
    static int NUMBER;
    static int LENGTH;
    static int[] ARR;
    static boolean[] VISITED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        NUMBER = Integer.parseInt(st.nextToken());
        LENGTH = Integer.parseInt(st.nextToken());

        ARR = new int[LENGTH];
        VISITED = new boolean[NUMBER];

        dfs(0);

        System.out.println(SB);
        br.close();
    }

    static void dfs(int depth) {
        if (LENGTH == depth) {
            for (int val : ARR) {
                SB.append(val).append(" ");
            }
            SB.append("\n");
            return;
        }

        for (int i = 0; i < NUMBER; i++) {
            if (!VISITED[i]) {
                if (depth != 0 && ARR[depth - 1] > i + 1) {
                    continue;
                }

                VISITED[i] = true;
                ARR[depth] = i + 1;
                dfs(depth + 1);
                VISITED[i] = false;

            }
        }
    }
}
