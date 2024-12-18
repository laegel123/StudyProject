package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012_2 {
    static int[] DX = {-1, 1, 0, 0};
    static int[] DY = {0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] MAP;
    static boolean[][] VISITED;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            MAP = new int[N][M];
            VISITED = new boolean[N][M];
            
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                MAP[x][y] = 1;
            }
            

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (MAP[i][j] == 1 && !VISITED[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        VISITED[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + DX[i];
                int ny = now[1] + DY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                if (!VISITED[nx][ny] && MAP[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    VISITED[nx][ny] = true;
                }   
            }
        }
        
    }

}
