package com.example.codingtest.solve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-24
 */

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            result.add(1);
        }
        else if (rowIndex == 1) {
            result.add(1);
            result.add(1);
        }
        else {
            int index = 1;
            result.add(1);
            result.add(1);
            while (index != rowIndex) {
                result = getList(result, index++);
            }
        }
        
        return result;
    }
    
    public List<Integer> getList(List<Integer> beforeList, int rowIndex) {
        List<Integer> newList = new ArrayList<>();
        
        newList.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            newList.add(beforeList.get(i - 1) + beforeList.get(i));
        }
        newList.add(1);
        
        return newList;
    }

    public List<Integer> getRow2 (int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }
}

public class leetcode119 {
    public static void main(String[] args) {
        Solution119 solution = new Solution119();
        System.out.println(solution.getRow(4));
    }
}
