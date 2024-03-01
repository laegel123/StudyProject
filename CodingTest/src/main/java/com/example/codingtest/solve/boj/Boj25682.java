package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] startBArr = new int[n][m];
        int[][] startWArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                // B로시작
                if (str[j].equals("B") && (i + j) % 2 != 0
                    || str[j].equals("W") && (i + j) % 2 == 0) {
                    startBArr[i][j] = 1;
                }

                // W로시작
                if (str[j].equals("W") && (i + j) % 2 != 0
                    || str[j].equals("B") && (i + j) % 2 == 0) {
                    startWArr[i][j] = 1;
                }

            }
        }

        int[][] startBSumArr = new int[n + 1][m + 1];
        int[][] startWSumArr = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                startBSumArr[i + 1][j + 1] = startBSumArr[i + 1][j] + startBArr[i][j];
                startWSumArr[i + 1][j + 1] = startWSumArr[i + 1][j] + startWArr[i][j];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                startBSumArr[j][i] += startBSumArr[j - 1][i];
                startWSumArr[j][i] += startWSumArr[j - 1][i];
            }
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < m - k + 1; j++) {
                minCount = Math.min(minCount, startBSumArr[i + k][j + k] - startBSumArr[i + k][j] - startBSumArr[i][j + k] + startBSumArr[i][j]);
                minCount = Math.min(minCount, startWSumArr[i + k][j + k] - startWSumArr[i + k][j] - startWSumArr[i][j + k] + startWSumArr[i][j]);
            }
        }

        System.out.println(minCount);
    }
}
