package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-09-30
 */
public class codeup3702 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];


        System.out.println(recur(n, m));
        br.close();
    }

    public static int recur(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }

        if (arr[n][m] == 0) {
            arr[n][m] = (recur(n - 1, m) + recur(n, m - 1)) % 100000000;
        }

        return arr[n][m];
    }
}
