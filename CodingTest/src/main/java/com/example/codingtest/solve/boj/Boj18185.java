package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] counts = new Integer[n + 1];
        int totalPrice = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }


        int index = 1;
        while (index < n + 1) {
            if (counts[index] > 0) {
                int count = counts[index];
                totalPrice += 3 * count;

                if (index + 1 < n + 1) {
                    count = Math.min(count, counts[index + 1]);
                    totalPrice += 2 * count;
                    counts[index + 1] -= count;
                }

                if (index + 2 < n + 1) {
                    count = Math.min(count, counts[index + 2] - Math.min(counts[index + 1], counts[index + 2]));
                    totalPrice += 2 * count;
                    counts[index + 2] -= count;
                }

            }
            index++;
        }

        System.out.println(totalPrice);
        br.close();
    }
}
