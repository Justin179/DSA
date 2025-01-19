package datastructures.lc240606;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc554 {
    public static void main(String[] args) {
        // [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
//        Integer[][] twoDArray = new Integer[][]{
//                {1,2,2,1},
//                {3,1,2},
//                {1,3,2},
//                {2,4},
//                {3,1,2},
//                {1,3,1,1}};
        Integer[][] twoDArray = new Integer[][]{
                {1,1},
                {2},
                {1,1}};
        List<List<Integer>> list = twoDArrayToList(twoDArray);
        int bricks = leastBricks(list);
        System.out.println(bricks);
    }
    public static List<List<Integer>> twoDArrayToList(Integer[][] twoDArray) {
        List<List<Integer>> list = new ArrayList<>();
        for (Integer[] array : twoDArray) {
            list.add(Arrays.asList(array));
        }
        return list;
    }

    public static int leastBricks(List<List<Integer>> wall) {
        int leng = 0; // 6
        for(Integer temp : wall.get(0)){
            leng+=temp;
        }
        Map<Integer,Integer> map = new HashMap();
        // for(int i = 1; i<leng; i++){ // 1 2 3 4 5
        //     map.put(i,0);
        // }

        for(int i = 0; i<wall.size(); i++){
            List<Integer> list = wall.get(i);
            int sum = 0;
            for(int j = 0; j<list.size(); j++){
                int curr = list.get(j);
                // 1 2 2 1
                sum += curr;
                if(sum < leng){ // 6
                    map.put(sum, map.getOrDefault(sum,0)+1);
                }
            }
        }
        int min = wall.size();
        for(var entry : map.entrySet()){
            min = Math.min(min, wall.size() - (entry.getValue()));
        }
        return min;
    }
}
