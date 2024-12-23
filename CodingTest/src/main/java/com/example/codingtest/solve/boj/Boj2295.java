package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Boj2295 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (set.contains(arr[i] - arr[j])) {
                    max = Math.max(max, arr[i]);
                }
            }
        }

        System.out.println(max);
        br.close();
    }

}
