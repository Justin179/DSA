package datastructures.lc240330;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Lc2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        /*
         n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
         */
        List<Integer>[] parents = new ArrayList[n]; // 陣列裡面放list<Integer>
        for (int i = 0; i < n; ++ i) { // 0 1 2 3 4 5 6 7
            parents[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            parents[edge[1]].add(edge[0]);
        }


        TreeSet<Integer>[] ancestors = new TreeSet[n]; // // 陣列裡面放TreeSet<Integer>
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; ++ i) { // 0 1 2 3 4 5 6 7
            if (ancestors[i] == null) {
                dfs(i, parents, ancestors);
            }

            result.add(new ArrayList<>(ancestors[i]));
        }

        return result;
    }

    public void dfs(int node, List<Integer>[] parents, TreeSet<Integer>[] ancestors) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int parent: parents[node]) { // 3 -> 0 1
            set.add(parent);
            if (ancestors[parent] == null) {
                dfs(parent, parents, ancestors);
            }
            set.addAll(ancestors[parent]);
        }

        ancestors[node] = set;
    }
}
