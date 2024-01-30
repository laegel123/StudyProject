package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj2468 {
    static int N;
    static int[] DISTANCE_X = {0, 1, 0, -1};
    static int[] DISTANCE_Y = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited;
        Set<Integer> heightSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                heightSet.add(height);
                map[i][j] = height;
            }
        }


        int maxCount = 0;
        Iterator<Integer> it = heightSet.iterator();
        while (it.hasNext()) {
            int rain = it.next();
            int count = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > rain) {

                        dfs(i, j, map, visited, rain);
                        count++;
                    }
                }
            }

            maxCount = Math.max(maxCount, count);
        }


        System.out.println(maxCount);
        br.close();
    }

    static void dfs(int x, int y, int[][] map, boolean[][] visited, int rain) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DISTANCE_X[i];
            int nextY = y + DISTANCE_Y[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }

            if (!visited[nextX][nextY] && map[nextX][nextY] > rain) {
                dfs(nextX, nextY, map, visited, rain);
            }
        }
    }
}
