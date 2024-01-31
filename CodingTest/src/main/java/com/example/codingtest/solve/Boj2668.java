package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boj2668 {
    static int N;
    static Set<Integer> STORE = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] info = new int[N + 1];
        boolean[] visited;

        for (int i = 1; i < N + 1; i++) {
            info[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dfs(info, visited, info[i], i);
        }

        StringBuilder sb = new StringBuilder();
        if (STORE.size() == 0) {
            sb.append(0);
        } else {
            List<Integer> list = STORE.stream().sorted().toList();

            sb.append(list.size()).append("\n");
            list.forEach(sc -> {
                sb.append(sc).append("\n");
            });
        }

        System.out.println(sb);
        br.close();
    }

    static void dfs(int[] info, boolean[] visited, int w, int target) {
        if (target == w) {
            STORE.add(target);

            return;
        }

        if (!visited[w]) {
            visited[w] = true;
            dfs(info, visited, info[w], target);
            visited[w] = false;
        }
    }
}
