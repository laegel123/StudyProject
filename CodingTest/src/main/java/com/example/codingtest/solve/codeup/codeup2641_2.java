package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class codeup2641_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        int ways = 0;

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int current = state[0];
            int count = state[1];

            if (current == n) {
                ways++;
                continue;
            }

            if (current > n) continue;

            queue.add(new int[] {current + 1, Math.max(0, count - 1)});
            queue.add(new int[] {current + 2, Math.max(0, count - 1)});

            if (count == 0) {
                queue.add(new int[] {current + 3, 2});
            }
        }

        System.out.println(ways);
        br.close();
    }

}
