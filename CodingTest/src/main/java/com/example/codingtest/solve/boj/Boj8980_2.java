package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-04-29
 */
public class Boj8980_2 {
    static class Info {
        int start;
        int end;
        int boxCount;

        public Info(int start, int end, int boxCount) {
            this.start = start;
            this.end = end;
            this.boxCount = boxCount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int townCount = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());


        List<Info> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.add(new Info(x, y, z));
        }

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.end == o2.end) {
                    return Integer.compare(o1.start, o2.start);
                }
                return Integer.compare(o1.end, o2.end);
            }
        });

        int[] weights = new int[townCount + 1];
        for (int i = 1; i < townCount + 1; i++) {
            weights[i] = capacity;
        }

        long answer = 0;
        for (int i = 0; i < list.size(); i++) {

            // 실을 수 있는 최소 값
            Info info = list.get(i);
            int minWeight = Integer.MAX_VALUE;
            for (int j = info.start; j < info.end; j++) {
                minWeight = Math.min(minWeight, weights[j]);
            }

            if (minWeight > info.boxCount) {
                for (int j = info.start; j < info.end; j++) {
                    weights[j] -= info.boxCount;
                }

                answer += info.boxCount;
            } else {
                for (int j = info.start; j < info.end; j++) {
                    weights[j] -= minWeight;
                }

                answer += minWeight;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
