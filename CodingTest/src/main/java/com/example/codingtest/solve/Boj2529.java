package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2529 {
    static int N;
    static List<Integer> MEMORIES = new ArrayList<>();
    static List<StringBuilder> ANSWER_LIST = new ArrayList<StringBuilder>();
    static boolean[] VISITED = new boolean[10];
    static char[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ARR = new char[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = st.nextToken().charAt(0);
        }


        getMinDfs(0);

        System.out.println(ANSWER_LIST.get(ANSWER_LIST.size() - 1));
        System.out.println(ANSWER_LIST.get(0));
        br.close();
    }

    static void getMinDfs(int depth) {
        if (depth == N + 1) {
            if (isCollect()) {
                StringBuilder answer = new StringBuilder();
                for (int i = 0; i < MEMORIES.size(); i++) {
                    answer.append(MEMORIES.get(i));
                }

                ANSWER_LIST.add(answer);
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                MEMORIES.add(i);
                getMinDfs(depth + 1);
                VISITED[i] = false;
                MEMORIES.remove(MEMORIES.size() - 1);
            }
        }
    }

    static boolean isCollect() {
        for (int i = 0; i < N; i++) {
            if (ARR[i] == '<') {
                if (MEMORIES.get(i) > MEMORIES.get(i + 1)) {
                    return false;
                }
            } else {
                if (MEMORIES.get(i) < MEMORIES.get(i + 1)) {
                    return false;
                }
            }
        }

        return true;
    }
}
