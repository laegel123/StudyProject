package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18185_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] counts = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        int totalPrice = 0;
        for (int i = 0; i < n; i++) {
            // i 위치의 비용 3원 계산
            int count = counts[i];
            totalPrice += count * 3;

            // i+1 < n 확인 후 비용 2 계산
            // 계산한 개수만큼 차감 (개수 -> 최소값)
            if (i + 1 < n) {
                count = Math.min(count, counts[i + 1]);
                totalPrice += count * 2;
                counts[i + 1] -= count;
            }

            // i+2 < n 확인 후 비용 2 계산
            // 계산한 개수만큼 차감 (개수 -> 최소값)
            if (i + 2 < n) {
                count = Math.min(count, counts[i + 2] - Math.min(counts[i+1], counts[i+2]));
                totalPrice += count * 2;
                counts[i + 2] -= count;
            }
        }

        System.out.println(totalPrice);
        br.close();
    }
}
