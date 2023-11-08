package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetNum = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean[] isBrokenNumber = new boolean[10];

        if (n != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                isBrokenNumber[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int minCount = Math.abs(targetNum - 100);
        for (int i = 0; i < 999999; i++) {
            String[] strArr = String.valueOf(i).split("");
            boolean isContinue = true;
            for (int j = 0; j < strArr.length; j++) {
                if (isBrokenNumber[Integer.parseInt(strArr[j])]) {
                    isContinue = false;
                    break;
                }
            }

            if (isContinue) {
                minCount = Math.min(minCount, Math.abs(targetNum - i) + strArr.length);
            }
        }

        System.out.println(minCount);
    }
}
