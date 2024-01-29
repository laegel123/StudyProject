package com.example.codingtest.algorithm.dfs_bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
    private int length;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        length = v;
        adj = new LinkedList[length];
        // 인접 리스트 초기화
        for (int i = 0; i < length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void dfsSearch(int v) {
        boolean visited[] = new boolean[length];

        dfs(v, visited);
    }

    /**
     * dfs 재귀
     */
    void dfs(int v, boolean visited[]) {
        visited[v] = true;
        System.out.println(v + " ");

        ListIterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n]) {
                dfs(n, visited);
            }
        }
    }

    void bfsSearch(int v) {
        boolean[] visited = new boolean[length];

        bfs(v, visited);
    }

    /**
     * bfs queue
     */
    void bfs(int v, boolean visited[]) {
        LinkedList<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while (queue.size() != 0) {
            int w = queue.poll();
            System.out.println(w + " ");

            Iterator<Integer> i = adj[w].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
