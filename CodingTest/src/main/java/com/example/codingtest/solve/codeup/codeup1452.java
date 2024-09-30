package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-18
 */
public class codeup1452 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = partition(arr, lo, hi);
        quickSort(arr, lo, pivot);
        quickSort(arr, pivot + 1, hi);
    }

    static int partition(int[] arr, int left, int right) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = arr[left + (right - left) / 2];

        while (true) {

            do {
                lo++;
            } while (arr[lo] < pivot);

            do {
                hi--;
            } while (arr[hi] > pivot && lo <= hi);

            if (lo >= hi) {
                return hi;
            }

            swap(arr, lo, hi);
        }
    }

    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }
}
