package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-04-30
 */
public class Boj1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long oneWayCost = Integer.parseInt(st.nextToken());
        long crossWayCost = Integer.parseInt(st.nextToken());

        long answer = 0;
        long minWay = Math.min(x, y);

        long cost1, cost2, cost3;

        // 한 방향으로만 가는 경우
        cost1 = (x + y) * oneWayCost;

        // 대각선으로만 가는 경우
        if ((x + y) % 2 == 0) {
            cost2 = Math.max(x, y) * crossWayCost;
        } else {
            cost2 = (Math.max(x, y) - 1) * crossWayCost + oneWayCost;
        }

        // 대각선 + 한 방향
        cost3 = Math.min(x, y) * crossWayCost + Math.abs(x - y) * oneWayCost;

        System.out.println(Math.min(cost1, Math.min(cost2, cost3)));
        br.close();
    }
}
