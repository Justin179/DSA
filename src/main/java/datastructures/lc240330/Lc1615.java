package datastructures.lc240330;

import java.util.HashMap;
import java.util.HashSet;

public class Lc1615 {
    // https://www.youtube.com/watch?v=aDW_TH4uQn0 清楚
    public int maximalNetworkRank(int n, int[][] roads) { // n cities
        HashMap<Integer, HashSet<Integer>> map = build(roads, n);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // 0 1 2 3
            for (int j = 0; j < n; j++) { // 0 1 2 3
                if (j != i) { // 跟自己以外的城市
                    max = Math.max(map.get(i).size() + map.get(j).size() - (map.get(i).contains(j) ? 1 : 0), max);
                }
            }
        }

        return max;
    }
    /* build this wz data n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
        0 -> [1,3]
        1 -> [0,2,3]
        2 -> [1]
        3 -> [0,1]
     */
    public HashMap<Integer, HashSet<Integer>> build(int[][] roads, int n) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); // HashSet<Integer> 可以理解為不重複清單
        for (int i = 0; i < n; i++) { // 0 1 2 3
            map.put(i, new HashSet<>());
        }
        for (int[] road : roads) { // bi-directional 互加
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        return map;
    }
}
/*
java hashset example
    HashSet<String> cars = new HashSet<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
 */

