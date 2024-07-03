package com.example.codingtest.solve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-03
 */
class Solution15_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            
            int sum = nums[i] + nums[left] + nums[right];
            
            while (left < right) {
                if (sum < 0) {
                    left++;
                }
                else if (sum > 0) {
                    right--;
                }
                else {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
            }
        
        }
        
        return resultList;
    }
}

public class leetcode15_2 {
    public static void main(String[] args) {
        Solution15_2 solution = new Solution15_2();
        solution.threeSum(new int[]{0, 0, 0});
    }
}
