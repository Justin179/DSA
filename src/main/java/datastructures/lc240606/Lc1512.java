package datastructures.lc240606;

import java.util.HashMap;
import java.util.Map;

public class Lc1512 {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,1,1,3};
        numIdenticalPairs(input);
    }
    public static int numIdenticalPairs(int[] nums) {
        // num:counts
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int ans = 0;
        for(var entry : map.entrySet()){
            int val = entry.getValue();
            ans += (val*(val-1))/2;
        }
        return ans;
    }
}