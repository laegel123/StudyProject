package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(n == m ? 0 : bfs(n, m));
        br.close();
    }

    static int bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0});
        boolean[] visited = new boolean[100001];

        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = now[0];
                if (i == 0) next = next + 1;
                else if (i == 1) next = next - 1;
                else next = next * 2;
                
                if (next == m) {
                    return now[1] + 1;
                }

                if (next < 0 || next > 100000) continue;
                if (!visited[next]) {
                    queue.add(new int[] {next, now[1] + 1});
                    visited[next] = true;
                }
            }

            
        }

        return -1;
    }

}
