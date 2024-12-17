package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4179 {
    static int[] DX = {-1, 1, 0, 0};
    static int[] DY = {0, 0, 1, -1};
    static int N;
    static int M;
    static char[][] MAP;
    static boolean[][] VISITED;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new char[N][M];
        VISITED = new boolean[N][M];
        Queue<int[]> positionQueue = new LinkedList<>();
        Queue<int[]> fireQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = str.charAt(j);

                if (MAP[i][j] == 'J') {
                    positionQueue.add(new int[] {i, j, 0});
                } else if (MAP[i][j] == 'F') {
                    fireQueue.add(new int[] {i, j});
                }
            }
        }


        int result = bfs(positionQueue, fireQueue);
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        br.close();
    }

    static int bfs(Queue<int[]> positionQueue, Queue<int[]> fireQueue) {

        while (!positionQueue.isEmpty()) {
            int fireSize = fireQueue.size();

            for (int f = 0; f < fireSize; f++) {
                int[] fireNow = fireQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nfx = fireNow[0] + DX[i];
                    int nfy = fireNow[1] + DY[i];

                    if (nfx < 0 || nfx >= N || nfy < 0 || nfy >= M) continue;

                    if (MAP[nfx][nfy] == 'J' || MAP[nfx][nfy] == '.') {
                        MAP[nfx][nfy] = 'F';
                        fireQueue.add(new int[]{nfx, nfy});
                    }
                }
            }

            int positionSize = positionQueue.size();
            for (int f = 0; f < positionSize; f++) {
                int[] now = positionQueue.poll();

                if (now[0] == 0 || now[1] == 0 || now[0] == N - 1 || now[1] == M - 1) {
                    return now[2] + 1;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + DX[i];
                    int ny = now[1] + DY[i];
    
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || MAP[nx][ny] == '#' || MAP[nx][ny] == 'F') continue;
    
                    if (MAP[nx][ny] == '.' && !VISITED[nx][ny]) {
                        positionQueue.add(new int[]{nx, ny, now[2] + 1});
                        VISITED[nx][ny] = true;
                    }
                }
            }
            
            
        }

        return -1;
    }
}
