package com.anshuman;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    // combinationSum 3
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1 , k ,n , new ArrayList<>() , ans);
        return  ans;

    }
    public static void solve(int start ,int k, int n ,List<Integer> temp, List<List<Integer>> ans ){
        if (n == 0 && temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9 ; i++) {
            temp.add(i);
            solve(i+1,k , n- i ,temp,ans);
            temp.remove(temp.size()-1);

        }


    }




// combanication Sum

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        combinelement(0 , target , ans , candidates,new ArrayList<>());
        return  ans;


    }
    public static   void combinelement(int index , int target , List<List<Integer>>ans,int[] candidates, List<Integer> temp ){
        int n = candidates.length;
        // base case

        if (index ==  n){
            if (target == 0)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if (candidates[index] <= target){
            temp.add(candidates[index]);
            combinelement(index,target - candidates[index], ans,candidates,temp);
           temp.remove(temp.size() -1);
        }
        combinelement(index+1 , target , ans , candidates,temp);

    }
}
