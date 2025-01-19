package datastructures.lc240330;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
The main part of solving this quesion is, we have to construct a tree
and traverse through DFS(with cost given as time) :)
 */
public class Lc1376 {

    private int dfs(int manager, int[] informTime, Map<Integer, List<Integer>> adjList) {
        /* manager 0     1
            0
           1 2
          3
         [3,3,1,2] 分鐘
         */
        int maxTime = 0; // 每一層都有自己獨立的maxTime
        for (int subordinate : adjList.getOrDefault(manager, new ArrayList<>())) { // 1 2   3
            maxTime = Math.max(maxTime, dfs(subordinate, informTime, adjList));
        }
        return maxTime + informTime[manager]; // 2
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // [-1,0,0,1]
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) { // 0 1 2 3
            if (manager[i] != -1) {
                adjList.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i); // index 為下級
            }
        }
        /*
            0
           1 2
          3

         [3,3,1,2] 分鐘
         */

        return dfs(headID, informTime, adjList);
    }

}