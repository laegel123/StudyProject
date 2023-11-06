package com.example.codingtest.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Node node = new Node(n);

        String str = br.readLine();
        st = new StringTokenizer(str);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            node.add(v, w);
            node.add(w, v);
        }

        node.dfs(x, y, 0);

        System.out.println(node.returnCount());
    }

    static class Node {
        private int n;
        private LinkedList<Integer>[] nodes;
        private boolean[] visited;
        int finalCount = 0;

        Node(int x) {
            n = x;
            nodes = new LinkedList[x + 1];
            visited = new boolean[x + 1];

            for (int i = 0; i < n + 1; i++) {
                nodes[i] = new LinkedList<>();
            }
        }

        void dfs(int x, int y, int count) {
            visited[x] = true;
            count++;

            Iterator<Integer> iterator = nodes[x].iterator();
            while (iterator.hasNext()) {
                int n = iterator.next();

                if (n == y) {
                    finalCount = count;
                    return;
                }

                if (!visited[n]) {
                    dfs(n, y, count);
                }
            }
        }

        int returnCount() {
            return finalCount == 0 ? -1 : finalCount;
        }

        void add(int v, int w) {
            nodes[v].add(w);
        }
    }
}
