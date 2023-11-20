package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11723 {

    static int S = 0;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String operation = st.nextToken();
            int num = 0;
            if (!operation.equals("all") && !operation.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }

            if (operation.equals("add")) {
                add(num);
            } else if (operation.equals("remove")) {
                remove(num);
            } else if (operation.equals("check")) {
                check(num);
            } else if (operation.equals("toggle")) {
                toggle(num);
            } else if (operation.equals("all")) {
                all();
            } else if (operation.equals("empty")) {
                empty();
            }
        }

        System.out.println(SB);
        br.close();
    }


    static void add(int x) {
        S |= (1 << x);
    }

    static void remove(int x) {
        S &= ~(1 << x);
    }

    static void check(int x) {
        SB.append((S & (1 << x)) != 0 ? 1 : 0).append("\n");
    }

    static void toggle(int x) {
        S ^= (1 << x);
    }

    static void all() {
        S = (1 << 21) - 1;
    }

    static void empty() {
        S = 0;
    }


}
