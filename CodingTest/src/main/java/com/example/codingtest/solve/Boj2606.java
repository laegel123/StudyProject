package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int computerCount = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        Node node = new Node(computerCount);

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node.addNode(x, y);
            node.addNode(y, x);
        }

        node.dfs(1);

        // 1번 컴퓨터는 제외
        System.out.println(node.getInfectedComputerCount() - 1);
    }

    static class Node {
        int n; // 노드 개수
        LinkedList<Integer> nodes[];
        int infectedComputerCount = 0;
        boolean[] visited;

        Node(int v) {
            n = v;
            visited = new boolean[n + 1];
            nodes = new LinkedList[n + 1];

            // 노드 초기화
            for (int i = 0; i < n + 1; i++) {
                nodes[i] = new LinkedList<>();
            }
        }

        void dfs(int n) {
            visited[n] = true;
            infectedComputerCount++;

            Iterator<Integer> iterator = nodes[n].iterator();
            while (iterator.hasNext()) {
                int newComputer = iterator.next();

                if (!visited[newComputer]) {
                    dfs(newComputer);
                }
            }
        }

        void addNode(int x, int y) {
            nodes[x].add(y);
        }

        int getInfectedComputerCount() {
            return infectedComputerCount;
        }
    }

}
