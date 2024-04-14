package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewelry {
    int mass; // 무게
    int value; // 가격

    Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}

public class Boj1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jewelryCount = Integer.parseInt(st.nextToken());
        int bagCount = Integer.parseInt(st.nextToken());
        long[] bagWeights = new long[bagCount];
        Jewelry[] jewelries = new Jewelry[jewelryCount];

        Comparator<long[]> comparator = new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] != o2[0]) {
                    return Long.compare(o1[0], o2[0]);
                }
                return Long.compare(o2[1], o1[1]);
            }
        };

        for (int i = 0; i < jewelryCount; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < bagCount; i++) {
            bagWeights[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.mass == o2.mass) {
                    return o2.value - o1.value;
                }
                return o1.mass - o2.mass;
            }
        });
        Arrays.sort(bagWeights);

        long answer = 0;
        int index = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (long bagWeight : bagWeights) {
            while (index < jewelryCount && jewelries[index].mass <= bagWeight) {
                queue.offer(jewelries[index++].value);
            }

            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }

        System.out.println(answer);
        br.close();
    }
}
