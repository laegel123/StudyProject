package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Fill {
    int start, end;

    public Fill(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Boj1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Fill> queue = new PriorityQueue<>(new Comparator<Fill>() {
            @Override
            public int compare(Fill o1, Fill o2) {
                return Integer.compare(o1.start, o2.end);
            }
        });

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            queue.offer(new Fill(x, y));
        }


        int answer = 0;
        int fill = 0;

        while (!queue.isEmpty()) {
            Fill now = queue.poll();

            if (now.end < fill) {
                continue;
            }

            if (fill < now.start) {
                fill = now.start;
            }

            answer += (now.end - fill) / l;
            int remain = (now.end - fill) % l;
            fill = now.end;

            if (remain != 0) {
                answer++;
                fill += l - remain;
            }
        }


        System.out.println(answer);
        br.close();
    }
}
