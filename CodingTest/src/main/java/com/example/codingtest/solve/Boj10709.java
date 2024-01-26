package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            String str = br.readLine();
            int count = -1;
            boolean isCloudMoving = false;
            for (int j = 0; j < b; j++) {
                if (str.charAt(j) == 'c') {
                    count = 0;
                    isCloudMoving = true;
                    sb.append(count).append(" ");
                    continue;
                }

                if (isCloudMoving) {
                    count++;
                }
                sb.append(count).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
