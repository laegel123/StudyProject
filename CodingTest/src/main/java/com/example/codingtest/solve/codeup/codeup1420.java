package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-12
 */
public class codeup1420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arrStr = new String[101];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            arrStr[score] = s;
        }

        int index = 0;
        int i = 100;
        String result = "";

        while (index < 3) {
            if (arrStr[i] != null) {
                result = arrStr[i];
                index++;
            }

            i--;
        }

        System.out.println(result);
        br.close();
    }
}
