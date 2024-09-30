package com.example.codingtest.solve.codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-08-19
 */
public class codeup3004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Data> datas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            datas.add(new Data(i, Integer.parseInt(st.nextToken())));
        }
        
        Collections.sort(datas, Comparator.comparingInt(o -> o.value));
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[datas.get(i).index] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        
        System.out.println(sb);
        br.close();
    }
}

class Data {
    int index;
    int value;
    
    Data(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
