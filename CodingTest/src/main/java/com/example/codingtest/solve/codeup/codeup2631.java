package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup2631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 0;
        int start = 0;
        int end = 0;

        while (end < n) {
            sum += arr[end];

            while (sum > k) {
                sum -= arr[start];
                start++;
            }

            if (sum == k) {
                count++;
            }

            end++;
        }

        System.out.println(count);
        br.close();
    }

}
