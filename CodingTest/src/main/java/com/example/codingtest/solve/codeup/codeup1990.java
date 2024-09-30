package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-15
 */
public class codeup1990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            total += Integer.parseInt(str.substring(i, i + 1));
        }
        
        if (total % 3 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        br.close();
    }
}
