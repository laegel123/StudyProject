package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distanceX = {0, 1, 0, -1};
        int[] distanceY = {1, 0, -1, 0};
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            // 현재 칸이 0인 경우 count ++, 1로 변경
            if (room[startX][startY] == 0) {
                count++;
                room[startX][startY] = 1;
            }

            // 주변 4칸 탐색

            // 탐색 후 빈 칸 없는 경우 후진 and 벽이면 멈춤

            // 탐색 후 빈 칸 있는 경우 반시계 방향으로 90도 회전, 한 칸 전진
        }
    }
}
