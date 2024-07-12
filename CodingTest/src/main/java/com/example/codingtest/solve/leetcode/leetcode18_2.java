package com.example.codingtest.solve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-07-13
 */
class Solution18_2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];

                    if (sum < target) {
                        left++;
                    }
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }

        return resultList;
    }
}

public class leetcode18_2 {
    public static void main(String[] args) {
        Solution18_2 solution = new Solution18_2();
        solution.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0);
        //solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
    }
}
