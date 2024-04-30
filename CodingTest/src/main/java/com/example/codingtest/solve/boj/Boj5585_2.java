package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-04-30
 */
public class Boj5585_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 500 100 50 10 5 1

        int charge = 1000 - n;
        int count = 0;
        while (charge > 4) {
            if (charge / 500 > 0) {
                count += charge / 500;
                charge = charge % 500;
            } else if (charge / 100 > 0) {
                count += charge / 100;
                charge = charge % 100;
            } else if (charge / 50 > 0) {
                count += charge / 50;
                charge = charge % 50;
            } else if (charge / 10 > 0) {
                count += charge / 10;
                charge = charge % 10;
            } else if (charge / 5 > 0) {
                count += charge / 5;
                charge = charge % 5;
            }
        }

        count += charge;

        System.out.println(count);
        br.close();
    }
}
