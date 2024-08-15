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
public class codeup1754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String number1 = st.nextToken();
        String number2 = st.nextToken();
        
        if (number1.equals(number2)) {
            System.out.println(number1 + " " + number2);
        } else {
            if (number1.length() > number2.length()) {
                System.out.println(number2 + " " + number1);
            } else if (number1.length() < number2.length()) {
                System.out.println(number1 + " " + number2);
            } else {
                for (int i = 0; i < number1.length(); i++) {
                    int n1 = Integer.parseInt(number1.substring(i, i + 1));
                    int n2 = Integer.parseInt(number2.substring(i, i + 1));

                    if (n1 > n2) {
                        System.out.println(number2 + " " + number1);
                        break;
                    } else if (n2 > n1) {
                        System.out.println(number1 + " " + number2);
                        break;
                    }
                }
            }
        }    
    
        br.close();
    }
}
