package com.anshuman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // creat a 2d arraylist because of we have to represent in the from of graph

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());

        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);

        }
        //  we have to use the topo sort for check that we have a cycel or not
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int it :adj.get(i)) {
                indegree[it]++;
            }
        }

        // creat the queue and  add the elelemnt if it is degree zero
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0 ){
                queue.add(i);
            }

        }

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()){
            int node =  queue.peek();
            queue.poll();
            topo.add(node);

            // node is in your topo sort  so we have to remove the degree of it
            for (int it :adj.get(node))
            {
                indegree[it]--;
                if (indegree[it] == 0 ) queue.add(it);

            }
        }

        if (topo.size() == numCourses) return true;
        return false;



    }

}
