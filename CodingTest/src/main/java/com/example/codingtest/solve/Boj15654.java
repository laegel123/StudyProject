package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15654 {
    static int NUMBER;
    static int LENGTH;
    static int[] MEMORY;
    static int[] ARR;
    static boolean[] VISITED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        NUMBER = Integer.parseInt(st.nextToken());
        LENGTH = Integer.parseInt(st.nextToken());

        ARR = new int[NUMBER];
        VISITED = new boolean[NUMBER];
        MEMORY = new int[LENGTH];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NUMBER; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ARR);

        dfs(0);

        System.out.println(SB);
        br.close();
    }

    static void dfs(int depth) {
        if (LENGTH == depth) {
            for (int val : MEMORY) {
                SB.append(val).append(" ");
            }

            SB.append("\n");
            return;
        }

        for (int i = 0; i < NUMBER; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                MEMORY[depth] = ARR[i];
                dfs(depth + 1);
                VISITED[i] = false;
            }
        }

    }
}
