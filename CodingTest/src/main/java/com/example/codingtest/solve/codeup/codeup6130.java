package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-15
 */
public class codeup6130 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        double n = Double.parseDouble(str.substring(0, str.indexOf("x")));
        
        if (str.contains("+")) {
            double m = Double.parseDouble(str.substring(str.indexOf("+")));
            
            System.out.printf("-" + "%.2f%n", m / n);
        } else {
            double m = Double.parseDouble(str.substring(str.indexOf("-")));
            System.out.printf("%.2f%n", m / n);
        }

        br.close();
    }
}
