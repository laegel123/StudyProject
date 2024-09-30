package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-15
 */
public class codeup1097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[19][19];
        
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            
            for (int i = 0; i < 19; i++) {
                if (arr[i][y] == 1) {
                    arr[i][y] = 0;
                } else {
                    arr[i][y] = 1;
                }
                
                if (arr[x][i] == 1) {
                    arr[x][i] = 0;
                } else {
                    arr[x][i] = 1;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j <19; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}
