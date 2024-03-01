package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int building = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[building + 1];


        int resultCount = bfs(startPoint, target, building, up, down, visited);

        if (resultCount == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(resultCount);
        }

    }

    static int bfs(int startPoint, int target, int building, int up, int down, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPoint);
        int count = -1;

        while (!queue.isEmpty()) {
            int qSize = queue.size();

            count++;
            for (int c = 0; c < qSize; c++) {
                int now = queue.poll();

                if (now == target) {
                    return count;
                }

                if (now + up <= building && !visited[now + up]) {
                    queue.offer(now + up);
                    visited[now + up] = true;
                }
                if (now - down > 0 && !visited[now - down]) {
                    queue.offer(now - down);
                    visited[now - down] = true;
                }

            }
        }


        return -1;
    }
}
