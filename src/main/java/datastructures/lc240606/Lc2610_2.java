package datastructures.lc240606;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc2610_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,1,2,3,1};
        findMatrix(nums);
    }
    public static List<List<Integer>> findMatrix(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i :nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        /*
        1:3
        2:1
        3:2
        4:1
         */
        int max = 0;
        for(var entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        //  [1,3,4,1,2,3,1]
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<max; i++){
            List<Integer> list = new ArrayList<>();
            for(var entry : map.entrySet()){
                int count = entry.getValue();
                int key = entry.getKey();
                if(count>=1){
                    list.add(key);
                    map.put(key,map.get(key)-1);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}











