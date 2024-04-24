package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-04-24
 */
public class Boj3109_3 {
    static int[] DISTANCE_X = {-1, 0, 1};
    static int[] DISTANCE_Y = {1, 1, 1};
    static int COUNT = 0;
    static boolean[][] VISITED;
    static int R;
    static int C;
    static Character[][] MAP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        VISITED = new boolean[R][C];

        MAP = new Character[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                MAP[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }

        System.out.println(COUNT);
        br.close();
    }

    static boolean dfs(int x, int y) {
        if (y == C - 1) {
            COUNT++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int newX = x + DISTANCE_X[i];
            int newY = y + DISTANCE_Y[i];

            if (newX < 0 || newY < 0 || newX >= R || newY >= C) {
                continue;
            }

            if (MAP[newX][newY] == '.' && !VISITED[newX][newY]) {
                VISITED[newX][newY] = true;
                if (dfs(newX, newY)) {
                    return true;
                }
            }

        }
        return false;
    }

}
