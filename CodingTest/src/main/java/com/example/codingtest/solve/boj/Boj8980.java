package com.example.codingtest.solve.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Info {
    int sendVillageNum;
    int receiveVillageNum;
    int boxCount;

    public Info(int sendVillageNum, int receiveVillageNum, int boxCount) {
        this.sendVillageNum = sendVillageNum;
        this.receiveVillageNum = receiveVillageNum;
        this.boxCount = boxCount;
    }
}
public class Boj8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int villageCount = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());
        int boxInfoCount = Integer.parseInt(br.readLine());

        Comparator<Info> comparator = new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.receiveVillageNum != o2.receiveVillageNum) {
                    return Integer.compare(o1.receiveVillageNum, o2.receiveVillageNum);
                } else {
                    return Integer.compare(o1.sendVillageNum, o2.sendVillageNum);
                }
            }
        };

        Info[] infos = new Info[boxInfoCount + 1];
        for (int i = 1; i < boxInfoCount + 1; i++) {
            st = new StringTokenizer(br.readLine());
            infos[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(infos, 1, boxInfoCount + 1, comparator);

        int[] weight = new int[villageCount + 1];
        for (int i = 1; i < villageCount + 1; i++) {
            weight[i] = capacity;
        }

        long answer = 0;
        for (int i = 1; i < boxInfoCount + 1; i++) {
            Info info = infos[i];

            // 마을 범위에서 보낼 수 있는 최대 무게
            int maxWeight = Integer.MAX_VALUE;
            for (int j = info.sendVillageNum; j < info.receiveVillageNum; j++) {
                maxWeight = Math.min(maxWeight, weight[j]);
            }

            if (maxWeight > info.boxCount) {
                for (int j = info.sendVillageNum; j < info.receiveVillageNum; j++) {
                    weight[j] -= info.boxCount;
                }
                answer += info.boxCount;
            } else {
                for (int j = info.sendVillageNum; j < info.receiveVillageNum; j++) {
                    weight[j] -= maxWeight;
                }
                answer += maxWeight;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
