package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2644_2 {
    static int N;
    static int[][] MAP;
    static boolean[] VISITED;
    static int COUNT = 0;
    static int[] FAMILY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MAP = new int[N + 1][N + 1];
        VISITED = new boolean[N + 1];
        FAMILY = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            MAP[a][b] = 1;
            MAP[b][a] = 1;
        }

        if (!bfs(x, y)) {
            System.out.println(-1);
        } else {
            System.out.println(FAMILY[y]);
        }

        br.close();
    }

    static boolean bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        VISITED[x] = true;

        boolean isFamily = false;

        while (!queue.isEmpty()) {
            int nowX = queue.poll();
            if (nowX == y) {
                isFamily = true;
                break;
            }

            for (int i = 1; i < N + 1; i++) {
                if (!VISITED[i] && MAP[nowX][i] == 1) {
                    VISITED[i] = true;
                    FAMILY[i] = FAMILY[nowX] + 1;
                    queue.offer(i);
                }
            }
        }

        return isFamily;
    }
}
