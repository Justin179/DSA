package datastructures.lc240330;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lc1971_2 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{2,0}};
        validPath(3,edges,0,2);
    }

    static boolean found = false;
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> visited = new HashSet<>();

        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(i,new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            int s = edge[0];
            int d = edge[1];
            map.get(s).add(d);
            map.get(d).add(s);
        }

        dfs(map,visited,source,destination);
        return found;
    }

    private static void dfs(Map<Integer,List<Integer>> map, Set<Integer> visited, int source, int destination){
        if(visited.contains(source) || found){
            return;
        }
        visited.add(source);

        for(Integer nei : map.get(source)){
            if(nei==destination){
                found = true;
                break;
            }
            if(!visited.contains(nei)){
                dfs(map,visited,nei,destination);
            }

        }
    }
}
