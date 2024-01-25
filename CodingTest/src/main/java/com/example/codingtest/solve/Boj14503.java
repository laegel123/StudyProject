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
            boolean isEmptyRoom = false;
            int newX = 0;
            int newY = 0;
            for (int i = 0; i < 4; i++) {
                int[] distance = getDistance(d);
                if (room[startX + distance[0]][startY + distance[1]] == 0) {
                    isEmptyRoom = true;
                    newX = startX + distance[0];
                    newY = startY + distance[1];
                }
            }

            // 탐색 후 빈 칸 없는 경우 후진 and 벽이면 멈춤

            // 탐색 후 빈 칸 있는 경우 반시계 방향으로 90도 회전, 한 칸 전진
        }
    }

    static int[] getDistance(int d) {
        int[] result = new int[3];

        if (d == 0) {
            result[0] = 1;
            result[1] = -1;
            result[2] = 3;
        } else if (d == 1) {
            result[0] = -1;
            result[1] = -1;
            result[2] = 0;
        } else if (d == 2) {
            result[0] = -1;
            result[1] = 1;
            result[2] = 1;
        } else if (d == 3) {
            result[0] = 1;
            result[1] = 1;
            result[2] = 0;
        }

        return result;
    }
}
