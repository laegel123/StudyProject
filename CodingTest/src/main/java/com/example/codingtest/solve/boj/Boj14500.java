package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14500 {

    static int N;
    static int M;
    static int[][][] CASE = {
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // 네모 블럭
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // l블록 가로배치
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // l블록 세로 배치
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // ㅜ블록 배치
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}}, // ㅗ블록 배치
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}}, // ㅏ블록 배치
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}}, // ㅓ블록 배치
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // 4번째 블록 정배치
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}}, // 4번째 블록 정배치 대칭
            {{0, 0}, {0, -1}, {1, -1}, {1, -2}}, // 4번째 블록 우측 1회전
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // 4번째 블록 우측 1회전 대칭
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // L블록 배치
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}}, // L블록 대칭 배치
            {{0, 0}, {1, 0}, {0, 1}, {0, 2}}, // ㄱ블록(가로 긴 버전) 대칭 배치
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // ㄱ블록(가로 긴 버전) 배치
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, // ㄱ블룩(세로 긴 버전) 배치
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}}, // ㄱ블록(세로 긴 버전) 대칭 배치
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, // ㄴ블록 배치
            {{1, 0}, {1, 1}, {1, 2}, {0, 2}} // ㄴ블록 대칭 배치
    };

    static int[][] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ARR = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxScore = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxScore = Math.max(maxScore, getMaxScore(i, j));
            }
        }

        System.out.println(maxScore);
    }

    static int getMaxScore(int x, int y) {
        int maxScore = 0;

        for (int i = 0; i < CASE.length; i++) {
            int sum = 0;
            boolean isPossibleSum = false;
            for (int j = 0; j < 4; j++) {
                int newX = x + CASE[i][j][0];
                int newY = y + CASE[i][j][1];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
                    break;
                }

                sum += ARR[newX][newY];

                if (j == 3) {
                    isPossibleSum = true;
                }
            }

            if (isPossibleSum) {
                maxScore = Math.max(maxScore, sum);
            }
        }

        return maxScore;
    }
}
