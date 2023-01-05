package com.anshuman;

import java.util.*;

public class MostProfitableTree {
    // creat a list
    List<Integer> lis = new ArrayList<>();
    int maxsum = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // conver the array to the arraylist
        int n = amount.length;

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i , new HashSet<>());
        }
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
            graph.get(u).add(v);
        }
        // find path
        dfs(bob,0 ,graph , new ArrayList<>(){{add(bob);}},new HashSet<>(){{add(bob);}});

        // modify the tree
        for (int i = 0; i < lis.size()/2; i++) {
            amount[lis.get(i)] = 0 ;

        }
        if (lis.size() % 2  != 0) {
            int m  = lis.get(lis.size() /2);
            amount[m] /= 2;
        }

        // get result
        Set<Integer> visted = new HashSet<>();
        visted.add(0);
        maxpathsum(0,graph , amount , visted , amount[0]);
        return maxsum;



    }
    private boolean dfs (int root , int target , Map<Integer , Set<Integer>> graph ,List<Integer>curpath , Set<Integer> vis){
        if (root ==  target){
            lis = new ArrayList<>(curpath);
            return  true;
        }
        for (int nighbor : graph.get(root)){
            if (vis.contains(nighbor)) continue;
            vis.add(nighbor);
            curpath.add(nighbor);

            if (dfs(nighbor , target , graph , curpath , vis)) return  true;

            curpath.remove(curpath.size() - 1 );
            vis.remove(nighbor);
        }
        return  false;
    }
    private  void  maxpathsum(int root , Map<Integer , Set<Integer>> graph , int[]amount ,Set<Integer> visted , int cursum )
    {
        int cnt = 0 ;
        for (int child : graph.get(root)){
            if (visted.contains(child)) continue;
            visted.add(child);
            maxpathsum(child , graph , amount , visted , cursum + amount[child]);
            visted.remove(child);
            cnt++;

    }
        //leaf node
        if (cnt == 0 ) maxsum = Math.max(maxsum,cursum);
        return;
    }


}
