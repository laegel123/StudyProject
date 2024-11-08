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
public class codeup3733 {
    static Map<Integer, Integer> MAP = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int index = 0;
        int max = 0;
        for (int i = a; i <= b; i++) {
            int length = getLength(i);
            if (length > max) {
                max = length;
                index = i;
            }
        }

        System.out.println(index + " " + max);
        br.close();
    }

    static int getLength(int n) {
        int index = n;
        int length = 0;

        while (index != 1) {
            if (MAP.containsKey(index)) {
                length += MAP.get(index);
                break;
            }
            length++;

            if (index % 2 == 0) {
                index /= 2;
            } else {
                index = 3 * index + 1;
            }
        }
        MAP.put(n, length + 1);

        return length + 1;
    }

}
