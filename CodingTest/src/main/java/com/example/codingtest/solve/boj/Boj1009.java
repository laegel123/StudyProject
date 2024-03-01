package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a 를 b 번 곱한다. (x)
            int x = 1;
            for (int i = 0; i < b; i++) {
                x = x * a % 10;
            }

            if (x == 0) {
                x = 10;
            }
            // 값 저장
            sb.append(x).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
