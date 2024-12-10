package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18185_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        for (int i = 0; i < n; i ++) {
            int num = arr[i];
            total += 3 * num;
            arr[i] -= num;

            if (i + 1 < n) {
                num = Math.min(num, arr[i + 1]);
                total += 2 * num;
                arr[i + 1] -= num;
            }

            if (i + 2 < n) {
                num = Math.min(num, arr[i + 2] - Math.min(arr[i + 1], arr[i + 2]));
                total += 2 * num;
                arr[i + 2] -= num;
            }

        }

        System.out.println(total);
        br.close();
    }

}
