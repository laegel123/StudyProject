package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-15
 */
public class codeup1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("'").append(str.charAt(i)).append("'").append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}
