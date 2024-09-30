package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-09-30
 */
public class codeup3170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (map.containsKey(name)) {
                map.put(name, map.get(name) + value);
            } else {
                map.put(name, value);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            sb.append(map.containsKey(str) ? map.get(str) : 0).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
