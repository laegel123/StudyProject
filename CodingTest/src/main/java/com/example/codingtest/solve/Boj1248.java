package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1248 {
    static int N;
    static char[][] ARR;
    static List<Integer> MEMORIES = new ArrayList<>();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ARR = new char[N][N];

        int length = N * (N + 1) / 2;

        int x = 0;
        int y = 0;
        String str = br.readLine();
        for (int i = 0; i < length; i++) {
            ARR[x][y] = str.charAt(i);

            y++;
            if (y == N) {
                x++;
                y = x;
            }
        }

        dfs(0);

        br.close();
    }

    static void dfs(int depth) {
        if (depth == N) {
            MEMORIES.forEach(memory -> {
                SB.append(memory).append(" ");
            });

            System.out.println(SB);
            System.exit(0);
        }

        for (int i = -10; i < 11; i++) {
            MEMORIES.add(i);
            if (isSumTrue(depth + 1)) {
                dfs(depth + 1);
            }
            MEMORIES.remove(MEMORIES.size() - 1);
        }


    }

    static boolean isSumTrue(int depth) {
        for (int i = 0; i < depth; i++) {
            int sum = 0;

            for (int j = i; j < depth; j++) {
                sum += MEMORIES.get(j);

                char c = sum == 0 ? '0' : (sum > 0 ? '+' : '-');
                if (ARR[i][j] != c) {
                    return false;
                }
            }
        }

        return true;
    }
}
