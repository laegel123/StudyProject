package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697_2 {
    static int N;
    static int M;
    static boolean[] VISITED = new boolean[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
        br.close();
    }

    static int bfs() {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == M) {
                count = now[1];
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nextN = now[0];
                if (i == 0) {
                    nextN -= 1;
                } else if (i == 1) {
                    nextN += 1;
                } else {
                    nextN *= 2;
                }

                if (nextN < 0 || nextN > 100000) {
                    continue;
                }

                if (!VISITED[nextN + 100000]) {
                    VISITED[nextN + 100000] = true;
                    queue.offer(new int[]{nextN, now[1] + 1});
                }
            }
        }

        return count;
    }
}
