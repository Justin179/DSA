package datastructures.lc240330;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lc2368 {

    private int ans = 0;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //Store all edges according to nodes in 'neighbors'.
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            // 如果key已經存在於map，就拿出現有的list進行add
            // 如果key不存在於map，就put(key,new list)，再拿出現有的list進行add
            neighbors.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            neighbors.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        // Mark the nodes in 'restricted' as visited.
        Set<Integer> seen = new HashSet<>();
        for (int node : restricted) {
            seen.add(node);
        }

        dfs(0, neighbors, seen);
        return ans;
    }

    private void dfs(int currNode, Map<Integer, List<Integer>> neighbors, Set<Integer> seen) {
        // Mark 'currNode' as visited and increment 'ans' by 1.
        ans++;
        seen.add(currNode);

        // Go for unvisited neighbors of 'currNode'.
        for (int nextNode : neighbors.get(currNode)) {
            if (!seen.contains(nextNode)) {
                dfs(nextNode, neighbors, seen);
            }
        }
    }



}
