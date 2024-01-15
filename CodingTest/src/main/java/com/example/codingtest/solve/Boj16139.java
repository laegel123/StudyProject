package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[][] prefixSum = new int[26][s.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < 26; j++) {
                prefixSum[j][i] = prefixSum[j][i - 1];
            }

            for (int z = 97; z < 123; z++) {
                if (s.charAt(i - 1) == z) {
                    prefixSum[z - 97][i]++;
                }
            }
        }

        int x = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (x-- > 0) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int i = c - 97;
            sb.append(prefixSum[i][r + 1] - prefixSum[i][l]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
