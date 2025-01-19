package datastructures.lc240330;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
The main part of solving this quesion is, we have to construct a tree
and traverse through DFS(with cost given as time) :)
 */
public class Lc1376_2 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(manager[i], new ArrayList<>());
            graph.get(manager[i]).add(i);
        }
        /*
            0
           1 2
          3

         [3,3,1,2] 分鐘
         */

        return dfs(graph, headID, informTime);
    }

    int dfs(Map<Integer, List<Integer>> graph, int curHead, int[] informTime) {
        /* manager 0     1
            0
           1 2
          3
         [3,3,1,2] 分鐘
         */
        int curMax = 0;
        if (!graph.containsKey(curHead)) {
            return curMax;
        }
        for (int subordinate : graph.get(curHead)) {
            curMax = Math.max(curMax, dfs(graph, subordinate, informTime));
        }
        return curMax + informTime[curHead];
    }

}