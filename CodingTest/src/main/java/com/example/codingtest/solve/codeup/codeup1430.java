package com.example.codingtest.solve.codeup;

import java.io.*;
import java.util.*;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-13
 */
public class codeup1430 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st;

        int n = scanner.nextInt();

        HashSet<Integer> set = new HashSet<>();
        while (n-- > 0) {
            set.add(scanner.nextInt());
        }

        StringBuilder sb = new StringBuilder();
        int m = scanner.nextInt();
        while(m-- > 0) {
            sb.append(set.contains(scanner.nextInt()) ? 1 : 0).append(" ");
        }
        
        System.out.println(sb.toString().trim());
        scanner.close();
    }
}
