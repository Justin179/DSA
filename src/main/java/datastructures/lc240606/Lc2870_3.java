package datastructures.lc240606;

import java.util.HashMap;

public class Lc2870_3 {
    public int minOperations(int[] nums) { // 2,3,3,2,2,4,2,3,4
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        /*
        2: 4
        3: 3
        4: 2
         */
        int ans = 0;
        for(var i : map.entrySet()){
            Integer count = i.getValue();
            if(count==1){
                return -1;
            } else if(count%3==0){
                ans += count/3;
            } else {
                ans += count/3 + 1;
            }
        }
        return ans;
    }
}
