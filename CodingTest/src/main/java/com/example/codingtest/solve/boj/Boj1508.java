package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj1508 {
    static int n, m, k;
    static List<Integer> human = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            human.add(Integer.parseInt(st.nextToken()));
        }

        // 가까운 두 심판의 거리가 최대 길이 구하기
        int left = 0;
        int right = n;
        List<Integer> tempRet;
        List<Integer> ret = new ArrayList<>();

        while (left <= right) {
            int mid = (left + right) / 2;
            tempRet = decision(mid);

            if (!tempRet.isEmpty()) {
                left = mid + 1;
                ret = new ArrayList<>(tempRet);
            } else {
                right = mid - 1;
            }
        }

        for (int num : ret) {
            System.out.print(num);
        }

        br.close();
    }

    // 두 심판의 거리가 gap 길이일 때 m명을 배치할 수 있는지 확인
    static List<Integer> decision(int gap) {
        List<Integer> ret = new ArrayList<>();
        int limit = -1;
        int cnt = 0;

        for (int i = 0; i < human.size(); i++) {
            if (limit <= human.get(i)) {
                cnt++;
                limit = human.get(i) + gap;
                ret.add(1);

                if (cnt == m) {
                    while (ret.size() != human.size())
                        ret.add(0);

                    break;
                }
            } else {
                ret.add(0);
            }
        }

        if (cnt == m)
            return ret;

        ret.clear();
        return ret;
    }
}
