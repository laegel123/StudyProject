package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2606_4 {
    static int N;
    static int[][] MAP;
    static boolean[] VISITED;
    static int COUNT = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        MAP = new int[N + 1][N + 1];
        VISITED = new boolean[N + 1];

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            MAP[x][y] = 1;
            MAP[y][x] = 1;
        }

        dfs(1);
        System.out.println(COUNT - 1);
        br.close();
    
    }

    static void dfs(int x) {
        VISITED[x] = true;
        COUNT++;

        for (int i = 1; i < N + 1; i++) {
            if (MAP[x][i] == 1 && !VISITED[i]) {
                dfs(i);
            }
            
        }
    }

}
