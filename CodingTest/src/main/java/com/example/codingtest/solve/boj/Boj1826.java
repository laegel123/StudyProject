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
public class Boj1826 {
    static class Info {
        int position;
        int size;

        public Info(int position, int size) {
            this.position = position;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Queue<Info> infoQueue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return Integer.compare(o1.position, o2.position);
            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            infoQueue.offer(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int curFuel = Integer.parseInt(st.nextToken());

        // 충전할 수 있는 연료들
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int count = 0;

        while (curFuel < target) {
            while (!infoQueue.isEmpty() && infoQueue.peek().position <= curFuel) {
                queue.offer(infoQueue.poll().size);
            }

            if (queue.isEmpty()) {
                count = -1;
                break;
            }

            count++;
            curFuel += queue.poll();
        }

        System.out.println(count);
        br.close();
    }
}





