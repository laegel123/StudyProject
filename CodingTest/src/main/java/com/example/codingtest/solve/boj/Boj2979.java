package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2979 {
    public static void main(String[] argss) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] count = new int[101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < y; j++) {
                count[j]++;
            }
        }

        int price = 0;
        for (int i = 1; i < 101; i++) {
            if (count[i] == 1) {
                price += count[i] * a;
            } else if (count[i] == 2) {
                price += count[i] * b;
            } else if (count[i] == 3) {
                price += count[i] * c;
            }
        }

        System.out.println(price);
        br.close();
    }
}
