package com.example.codingtest.solve.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class leetcode80 {
    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> count = new LinkedHashMap<>();
        for(int n: nums){
            if(!count.containsKey(n)){
                count.put(n, 1);
            }
            else {
                count.put(n, count.get(n) + 1);
            }
        }

        int index = 0;
        for(Integer key: count.keySet()){
            if(count.get(key) == 1){
                nums[index++] = key;;
            }
            else {
                nums[index++] = key;
                nums[index++] = key;
            }
        }

        return index;
    }
}
