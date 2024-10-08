package com.example.codingtest.solve.codeup;

import java.util.Scanner;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-10-08
 */
public class codeup2628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = sc.nextInt();
        int d = sc.nextInt();

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (c > d) {
            int temp = c;
            c = d;
            d = temp;
        }

        boolean cross = false;

        if ((a < c && c < b && b < d) || (c < a && a < d && d < b)) {
            cross = true;
        }

        if (cross) {
            System.out.println("cross");
        } else {
            System.out.println("not cross");
        }

        sc.close();

    }
}
