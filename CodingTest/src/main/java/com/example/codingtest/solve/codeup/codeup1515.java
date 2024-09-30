package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-17
 */
public class codeup1515 {
    static int[] DISTANCE_X = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] DISTANCE_Y = {0 , 0, 1, -1, 1, -1, -1, 1};
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[25][25];
        int[][] nextMap = new int[25][25];
        
        for (int i = 0; i < 25; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 25; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                nextMap[i][j] = x;
            }
        }
        
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                nextMap[i][j] = getNextLife(map, i, j);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                sb.append(nextMap[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
    
    static int getNextLife(int[][] map, int x, int y) {
        int lifeCount = 0;
        
        for (int i = 0; i < 8; i++) {
            int newX = x + DISTANCE_X[i];
            int newY = y + DISTANCE_Y[i];
            
            if (newX < 0 || newX > 24 || newY < 0 || newY > 24) continue;
            
            if (map[newX][newY] == 1) {
                lifeCount++;
            }
        }
        
        if (lifeCount == 3) {
            return 1;
        } else if (lifeCount >= 4 || lifeCount <= 1) {
            return 0;
        } else if (lifeCount == 2 || lifeCount == 3) {
            return map[x][y];
        } else {
            return 0;
        }
    }
}
