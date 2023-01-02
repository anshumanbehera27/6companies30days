package com.anshuman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums){
        //sort the array
        Arrays.sort(nums);

        //creat a dp array which is fill with one
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1 ;
        int prev = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] <= dp[j]){
                    dp[i] = dp[j] +1 ;

                }
                if (max < dp[i]){
                    max = dp[i];
                    prev = dp[i];
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length-1 ; i >=0 ; i--) {
            if (max == dp[i] && prev % nums[i] == 0){
                list.add(nums[i]);
                max -= 1 ;
                prev = nums[i];
            }

        }
        return list;
    }
}
