package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1781 {
    static int N;
    static Sort[] SORTS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        SORTS = new Sort[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int noodleCount = Integer.parseInt(st.nextToken());
            SORTS[i] = new Sort(deadLine, noodleCount);
        }

        Arrays.sort(SORTS);

        Queue<Integer> queue = new PriorityQueue<>();

        for (Sort sort : SORTS) {
            int size = queue.size();
            if (size < sort.deadLine) {
                queue.add(sort.noodleCount);
            } else if (size == sort.deadLine) {
                int peek = queue.peek();
                if (peek < sort.noodleCount) {
                    queue.poll();
                    queue.add(sort.noodleCount);
                }
            }
        }

        long totalCount = 0;
        while (!queue.isEmpty()) {
            totalCount += queue.poll();
        }

        System.out.println(totalCount);
        br.close();
    }
}

class Sort implements Comparable<Sort> {
    int deadLine;
    int noodleCount;

    Sort(int deadLine, int noodleCount) {
        this.deadLine = deadLine;
        this.noodleCount = noodleCount;
    }

    @Override
    public int compareTo(Sort o) {
        if (this.deadLine < o.deadLine) {
            return -1;
        } else if (this.deadLine == o.deadLine) {
            if (this.noodleCount > o.noodleCount) {
                return -1;
            } else if (this.noodleCount == o.noodleCount) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
