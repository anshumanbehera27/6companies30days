package com.anshuman;

import java.util.Enumeration;

public class maxRotateFunction {
    // optmzed solution
    // tc- 0(n)
    //sc - 0(n)
    public int maxRotateFunction(int[] nums){
        // base case for dp
        int n = nums.length;
        if (nums == null || nums.length == 0 ) return  0 ;

        // find the sum of all array and find the F0
        int sum = 0 ;
        int f0 =  0 ;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <n; i++) {
            sum += nums[i];
            f0 += i* nums[i];

        }
        // create a dp array to impliment it
        int[] dp =  new int[n];
        dp[0] = f0;
        max = dp[0];
        for (int i = 0; i < n; i++)
        {
            dp[i] = dp[i-1] + sum - n * nums[n - i];
            max = Math.max(max , dp[i]);

        }
        return max;
    }







    //broute froce solution
    // TC - o(n^2)
    // sc - 0(n)
    public int maxRotateFunctionBT(int[] nums) {
        int Maxval = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            rotateArr(nums,i);
            int sum = 0 ;
            for (int j = 0; j < nums.length; j++) {
                sum += j * nums[j];
            }
            Maxval = Math.max(Maxval,sum);
        }
        return Maxval;
    }
    public void rotateArr(int[] nums , int k){
       swap(0,nums.length,nums);
       swap(0,k-1,nums);

    }
    public void swap(int i , int j , int[] arr ) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
