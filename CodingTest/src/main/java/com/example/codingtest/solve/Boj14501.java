package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14501 {
    static int T;
    static int[][] TIME;
    static int[] PAY;
    static List<Integer> PAY_LIST = new ArrayList<>();
    static int MAX_SUM = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        TIME = new int[T + 1][1];
        PAY = new int[T + 1];

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            TIME[i][0] = Integer.parseInt(st.nextToken());
            PAY[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);

        System.out.println(MAX_SUM);
        br.close();
    }

    static void dfs(int day, int remainingTime) {
        if (day == T) {
            int sum = 0;
            for (int i = 0; i < PAY_LIST.size(); i++) {
                sum += PAY_LIST.get(i);
            }

            MAX_SUM = Math.max(MAX_SUM, sum);
            return;
        }


        for (int i = day; i < T + 1; i++) {
            if (remainingTime == 0 && T - day >= TIME[i][0]) {
                PAY_LIST.add(PAY[day]);
                remainingTime = TIME[i][0];
            } else {
                PAY_LIST.add(0);
            }

            if (remainingTime > 0) {
                dfs(day + 1, remainingTime - 1);
            } else {
                dfs(day + 1, remainingTime);
            }

            PAY_LIST.remove(day-1);
        }
    }
}
