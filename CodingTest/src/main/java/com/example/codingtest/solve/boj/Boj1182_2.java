package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182_2 {
    static int COUNT = 0;
    static int N;
    static int S;
    static int[] ARR;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        ARR = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);

        if (S == 0) COUNT--;

        System.out.println(COUNT);
        br.close();
    }

    static void recur(int index, int sum) {
        if (index == N) {
            if (sum == S) COUNT++;
            return;
        }

        recur(index + 1, sum);
        recur(index + 1, sum + ARR[index]);
    }

}
