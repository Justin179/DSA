package datastructures.lc240606;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc229_2 {
    public List<Integer> majorityElement(int[] nums) { // 3 2 3
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(var entry : map.entrySet()){
            Integer count = entry.getValue();
            Integer key = entry.getKey();
            if(count > nums.length/3){
                list.add(key);
            }
        }
        return list;
    }
}
