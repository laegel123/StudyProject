package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14501 {
    static int T;
    static int[] TIME;
    static int[] PAY;
    static List<Integer> PAY_LIST = new ArrayList<>();
    static int MAX_SUM = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        TIME = new int[T];
        PAY = new int[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            TIME[i] = Integer.parseInt(st.nextToken());
            PAY[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(MAX_SUM);
        br.close();
    }

    static void dfs(int day, int pay) {
        if (day >= T) {
            MAX_SUM = Math.max(MAX_SUM, pay);
            return;
        }

        if (day + TIME[day] <= T) {
            dfs(day + TIME[day], pay + PAY[day]);
        } else {
            dfs(day + TIME[day], pay);
        }

        dfs(day + 1, pay);
    }
}
