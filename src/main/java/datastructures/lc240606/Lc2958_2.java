package datastructures.lc240606;

import java.util.HashMap;
import java.util.Map;

public class Lc2958_2 {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int l=0, r=0; r<nums.length; r++){
            int curr = nums[r];
            map.put(curr,map.getOrDefault(curr,0)+1);
            while (map.get(curr) > k){
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                l++;
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}
