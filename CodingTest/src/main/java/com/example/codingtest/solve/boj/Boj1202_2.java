package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-04-25
 */
public class Boj1202_2 {
    static class Info {
        int weight;
        int price;

        public Info(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Info[] jewleryInfos = new Info[n];
        long[] weights = new long[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewleryInfos[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < k; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewleryInfos, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.weight == o2.weight) {
                    return Integer.compare(o2.price, o1.price);
                }
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        Arrays.sort(weights);

        Queue<Integer> resultQueue = new PriorityQueue<>(Comparator.reverseOrder());

        long answer = 0;
        int index = 0;
        for (long weight : weights) {
            while (index < n && jewleryInfos[index].weight <= weight) {
                resultQueue.offer(jewleryInfos[index++].price);
            }

            if (!resultQueue.isEmpty()) {
                answer += resultQueue.poll();
            }
        }

        System.out.println(answer);
        br.close();
    }
}
