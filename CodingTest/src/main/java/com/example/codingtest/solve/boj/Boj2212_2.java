package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-04-30
 */
public class Boj2212_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] sensors = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for (int i = 0; i < n - 1; i++) {
            queue.offer(sensors[i + 1] - sensors[i]);
        }

        int answer = 0;
        if (m < n) {
            for (int i = 0; i < n - m; i++) {
                answer += queue.poll();
            }
        }

        System.out.println(answer);
        br.close();
    }
}
