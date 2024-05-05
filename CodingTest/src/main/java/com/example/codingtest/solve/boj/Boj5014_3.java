package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5014_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int buildingLength = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        int objectivePosition = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int count = bfs(buildingLength, now, objectivePosition, up, down);

        if (count == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(count);
        }

        br.close();
    }

    static int bfs(int buildingLength, int start, int objectivePosition, int up, int down) {
        boolean[] visited = new boolean[1000001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        int count = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == objectivePosition) {
                count = now[1];
                break;
            }

            for (int i = 0; i < 2; i++) {
                int next = now[0];
                if (i == 0) {
                    next += up;
                } else {
                    next -= down;
                }

                if (next <= 0 || next > buildingLength) {
                    continue;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, now[1] + 1});
                }
            }
        }

        return count;
    }
}
