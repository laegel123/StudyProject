package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1781_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Queue<Integer> result = new PriorityQueue<>();
        long answer = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            result.add(now[1]);
            if (result.size() > now[0]) {
                result.poll();
            }
        }
        while (!result.isEmpty()) {
            answer += result.poll();
        }

        System.out.println(answer);
        br.close();
    }
}
