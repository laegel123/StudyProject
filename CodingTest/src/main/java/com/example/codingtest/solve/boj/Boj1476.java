package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int targetE = Integer.parseInt(st.nextToken());
        int targetS = Integer.parseInt(st.nextToken());
        int targetM = Integer.parseInt(st.nextToken());

        int e = 0;
        int s = 0;
        int m = 0;

        int year = 0;
        while (true) {
            if (e == targetE && s == targetS && m == targetM) {
                break;
            }

            e++;
            m++;
            s++;

            if (e == 16) {
                e = 1;
            }

            if (s == 29) {
                s = 1;
            }

            if (m == 20) {
                m = 1;
            }

            year++;
        }

        System.out.println(year);
    }
}
