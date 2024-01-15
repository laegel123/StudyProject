package com.example.codingtest.solve;

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

        int[][] arr = new int[n][m];
        int[][] reverse = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (str[j].equals("B") && (i + j) % 2 != 0) {
                    arr[i][j] = 1;
                }

                if (str[j].equals("W") && (i + j) % 2 != 0) {
                    reverse[i][j] = 1;
                }
            }
        }

        int[][] changeArr = new int[n + 1][m + 1];
        int[][] reverseArr = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                changeArr[i + 1][j + 1] = changeArr[i + 1][j] + arr[i][j];
                reverseArr[i + 1][j + 1] = reverseArr[i + 1][j] + reverse[i][j];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                changeArr[j][i] += changeArr[j - 1][i];
                reverseArr[j][i] += reverseArr[j - 1][i];
            }
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < m - k + 1; j++) {
                minCount = Math.min(minCount, changeArr[i + k][j + k] - changeArr[i + k][j] - changeArr[i][j + k]);
                minCount = Math.min(minCount, reverseArr[i + k][j + k] - reverseArr[i + k][j] - reverseArr[i][j + k]);
            }
        }

        System.out.println(minCount);
    }
}
