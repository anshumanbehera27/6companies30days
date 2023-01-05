package com.anshuman;

public class FIndtheUnsortedSubarray {
    // TC 0(n)
    //sc 0(1)
    public int findUnsortedSubarray(int[] nums) {
        // first we have to find the end point and star point in that array
        // and we can find the ans by end- start + 1
       int n = nums.length;

       // find the end point
        int end = -1 ;
        int max = nums[0];
        for (int i = 1; i < n ; i++) {
            if (max > nums[i]){
                end = i ;
            }
            else max = nums[i];
        }
        // find the start point
        int start = 0 ;
        int min = nums[n-1];
        for (int i = n-2; i > 0 ; i--) {
            if (min < nums[i]){
                start = i ;
            }
            else min = nums[i];


        }
        return end - start +1 ;



    }
}
