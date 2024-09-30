package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-09-30
 */
public class codeup3108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            if (type.equals("I")) {
                map.put(num, str);
            } else if (type.equals("D")) {
                map.remove(num);
            }
        }

        // sort
        List<Integer> sorted = new ArrayList<>(map.keySet());
        Collections.sort(sorted);

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreElements()) {
            int index = Integer.parseInt(st.nextToken()) - 1;
            sb.append(sorted.get(index)).append(" ").append(map.get(sorted.get(index))).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
