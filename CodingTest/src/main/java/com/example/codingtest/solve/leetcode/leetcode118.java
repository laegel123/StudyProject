package com.example.codingtest.solve.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-24
 */

/*
         1
        1 1
       1 2 1
      1 3 3 1
     1 4 6 4 1
    1 5 10 10 5 1
   1 6 15 20 15 6 1

 */
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            if (i == 0) {
                newList.add(1);
                result.add(newList);
                continue;
            }
            else if (i == 1) {
                newList.add(1);
                newList.add(1);
                result.add(newList);
                continue;
            }
            else {
                newList = getList(result.get(i - 1), i);
            }
            
            result.add(newList);
        }

        return result;
    }
    
    public List<Integer> getList(List<Integer> beforeList, int numRow) {
        List<Integer> newList = new ArrayList<>();
        newList.add(0, 1);
        
        for (int i = 1; i < numRow; i++) {
            newList.add(i, beforeList.get(i - 1) + beforeList.get(i));
        }

        newList.add(numRow, 1);
        
        return newList;
    }
}

public class leetcode118 {
    public static void main(String[] args) {
        Solution118 solution = new Solution118();
        System.out.println(solution.generate(1));
    }
}
