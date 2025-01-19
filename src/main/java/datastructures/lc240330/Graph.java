package datastructures.lc240330;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{2,0},{2,3}};
        Map<Integer, List<Integer>> integerListMap = buildGraph(edges);
        System.out.println(integerListMap);
    }
    public static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) { // x,y {0,1},{1,2},{2,0},{2,3}
            int x = edge[0], y = edge[1];
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            graph.get(x).add(y);

            // if (!graph.containsKey(y)) {
            //     graph.put(y, new ArrayList<>());
            // }
            // graph.get(y).add(x);

            // uncomment the above lines if the graph is undirected
        }

        return graph;
    }
}
