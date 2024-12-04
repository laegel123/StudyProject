package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        recur(start, end);
        br.close();
    }

    static void recur(int start, int end) {
        if (start > end) return;
        if (start % 2 != 0) System.out.print(start + " ");
        recur(start + 1, end);
        
    }

}
