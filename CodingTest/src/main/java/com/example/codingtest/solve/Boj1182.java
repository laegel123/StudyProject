package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1182 {

    static int N;
    static int TARGET_NUM;
    static int[] ARR;
    static List<Integer> MEMORIES = new ArrayList<>();
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        TARGET_NUM = Integer.parseInt(st.nextToken());

        ARR = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0, 0);

        System.out.println(COUNT);
        br.close();
    }

    static void dfs(int depth, int start) {
        if (depth >= 1 && depth <= N) {
            int sum = 0;
            for (int i = 0; i < MEMORIES.size(); i++) {
                sum += MEMORIES.get(i);
            }

            if (sum == TARGET_NUM) {
                COUNT++;
            }
        }

        for (int i = start; i < N; i++) {
            MEMORIES.add(ARR[i]);
            dfs(depth + 1, i + 1);
            MEMORIES.remove(MEMORIES.size() - 1);
        }
    }
}
