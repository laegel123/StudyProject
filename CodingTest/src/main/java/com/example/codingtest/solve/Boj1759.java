package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1759 {
    static int LENGTH;
    static int NUMBER;
    static char[] ALPABET;
    static char[] MEMORY;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LENGTH = Integer.parseInt(st.nextToken());
        NUMBER = Integer.parseInt(st.nextToken());

        ALPABET = new char[NUMBER];
        MEMORY = new char[LENGTH];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NUMBER; i++) {
            ALPABET[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(ALPABET);

        dfs(0);

        System.out.println(SB);
        br.close();
    }

    static void dfs(int depth) {
        if (LENGTH == depth) {
            int vowelCount = 0;
            int consonantCount = 0;
            for (char c : MEMORY) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }

            if (vowelCount > 0 && consonantCount > 1) {
                SB.append(String.valueOf(MEMORY)).append("\n");
            }

            return;
        }

        for (int i = 0; i < NUMBER; i++) {
            if (depth != 0 && (MEMORY[depth - 1] > ALPABET[i] || MEMORY[depth - 1] == ALPABET[i])) {
                continue;
            }

            MEMORY[depth] = ALPABET[i];
            dfs(depth + 1);
        }

    }
}
