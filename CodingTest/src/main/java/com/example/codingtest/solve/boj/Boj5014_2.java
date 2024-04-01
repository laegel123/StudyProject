package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5014_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int building = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());


        bfs(now, target, up, down, building);
        br.close();
    }

    public static void bfs(int start, int target, int up, int down, int building) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        boolean[] visited = new boolean[building + 1];
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == target) {
                System.out.println(now[1]);
                return;
            }

            int[] newUp = new int[2];
            int[] newDown = new int[2];

            newUp[0] = now[0] + up;
            newUp[1] = now[1] + 1;
            newDown[0] = now[0] - down;
            newDown[1] = now[1] + 1;


            if (newUp[0] > 0 && newUp[0] < building + 1 && !visited[newUp[0]]) {
                queue.add(newUp);
                visited[newUp[0]] = true;
            }

            if (newDown[0] > 0 && newDown[0] < building + 1 && !visited[newDown[0]]) {
                queue.add(newDown);
                visited[newDown[0]] = true;
            }
        }

        System.out.println("use the stairs");
    }


}
