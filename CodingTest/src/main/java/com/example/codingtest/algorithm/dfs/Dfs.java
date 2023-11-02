package com.example.codingtest.algorithm.dfs;

import java.util.Iterator;
import java.util.LinkedList;

public class Dfs {

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.start(2); /* 주어진 노드를 시작 노드로 DFS 탐색 */
        //g.start(); /* 비연결형 그래프의 경우 */
    }
}


class Graph {
    private int n; // 노드 개수
    private LinkedList<Integer> nodes[]; // 인접 노드 리스트

    Graph(int v) {
        n = v;
        nodes = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new LinkedList<>();
        }
    }

    void dfs(int n, boolean[] visited) {
        visited[n] = true;
        System.out.println(n + " ");

        // 방문한 노드와 인접한 노드를 가져온다.
        Iterator<Integer> iterator = nodes[n].iterator();
        while (iterator.hasNext()) {
            int x = iterator.next();

            // 방문하지 않았다면 순환
            if (!visited[x]) {
                dfs(x, visited);
            }
        }
    }

    // 주어진 값이 있을 때 시작 함수
    void start(int x) {
        boolean visited[] = new boolean[n];
        dfs(x, visited);
    }

    // 비 연결형의 경우 시작 함수
    void start() {
        boolean visited[] = new boolean[n];

        // 모든 정점을 하나씩 모두 방문
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }
    }

    // 노드 연결 함수
    void addEdge(int v, int w) {
        nodes[v].add(w);
    }


}
