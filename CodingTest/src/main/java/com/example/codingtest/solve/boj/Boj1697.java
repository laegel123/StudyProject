package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bfs(n, m);
        br.close();
    }

    static void bfs(int n, int m) {
        int[] countArr = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        countArr[n] = 1;

        while (!queue.isEmpty()) {
            int qSize = queue.size();

            for (int c = 0; c < qSize; c++) {
                int now = queue.poll();

                if (now == m) {
                    System.out.println(countArr[now] - 1);
                }

                for (int i = 0; i < 3; i++) {
                    int next = 0;

                    if (i == 0) {
                        next = now + 1;
                    } else if (i == 1) {
                        next = now - 1;
                    } else {
                        next = now * 2;
                    }

                    if (next >= 0 && next < 100001 && countArr[next] == 0) {
                        queue.add(next);
                        countArr[next] = countArr[now] + 1;
                    }
                }
            }
        }
    }
}
