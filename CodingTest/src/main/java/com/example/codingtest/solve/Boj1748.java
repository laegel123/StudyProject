package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int lengthSum = 0;
        int length = 1;
        int num = 10;

        for (int i = 1; i < n + 1; i++) {
            if (i % num == 0) {
                length++;
                num *= 10;
            }

            lengthSum += length;
        }

        System.out.println(lengthSum);
        br.close();
    }
}
