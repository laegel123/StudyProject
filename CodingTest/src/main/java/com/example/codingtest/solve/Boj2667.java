package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj2667 {

    static int N;
    static int[][] ARR;
    static boolean[][] VISITED;
    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        ARR = new int[N][N];
        VISITED = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] integers = str.split("");

            for (int j = 0; j < str.length(); j++) {
                ARR[i][j] = Integer.parseInt(integers[j]);
            }
        }



        int houseComplexCount = 0;
        ArrayList<Integer> houseCount = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                COUNT = 0;
                if (!VISITED[i][j] && ARR[i][j] != 0) {
                    houseComplexCount++;
                    dfs(i,j);

                    houseCount.add(COUNT);
                }
            }
        }

        sb.append(houseComplexCount).append("\n");

        Collections.sort(houseCount);
        houseCount.forEach(count -> {
            sb.append(count).append("\n");
        });

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        VISITED[x][y] = true;
        COUNT++;

        for (int i = 0; i < 4; i++) {
            int newX = x + DISTANCE_X[i];
            int newY = y + DISTANCE_Y[i];

            if (newX <0 || newY < 0 || newX >= N || newY >= N) {
                continue;
            }

            if (!VISITED[newX][newY] && ARR[newX][newY] != 0) {
                dfs(newX, newY);
            }
        }

    }
}
