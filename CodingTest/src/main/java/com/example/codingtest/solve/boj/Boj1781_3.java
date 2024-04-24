package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1781_3 {
    static class Info {
        int deadLine;
        int noodleCount;

        public Info(int deadLine, int noodleCount) {
            this.deadLine = deadLine;
            this.noodleCount = noodleCount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Queue<Info> queue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return Integer.compare(o1.deadLine, o2.deadLine);
            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            queue.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Queue<Integer> resultQueue = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            Info info = queue.poll();
            resultQueue.add(info.noodleCount);

            while (resultQueue.size() > info.deadLine) {
                resultQueue.poll();
            }

        }

        long answer = 0;
        while (!resultQueue.isEmpty()) {
            answer += resultQueue.poll();
        }

        System.out.println(answer);
        br.close();
    }
}
