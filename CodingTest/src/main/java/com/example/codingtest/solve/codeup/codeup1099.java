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
public class codeup1099 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[10][10];
        
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int i = 1;
        int j = 1;
        while (true) {
            if (arr[i][j] == 2) {
                arr[i][j] = 9;
                break;
            }
            
            arr[i][j] = 9;
            
            if (arr[i][j + 1] != 1) {
                j++;
            } else if (arr[i + 1][j] != 1) {
                i++;
            } else {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                sb.append(arr[x][y]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}
