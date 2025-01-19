package datastructures.lc240606;

import java.util.HashMap;
import java.util.Map;

public class Lc525 {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int currNum = nums[i];
            if(currNum==1){
                count+=1;
            }else {
                count+=-1;
            }
            if(count==0){
                max = Math.max(max,i-0+1);
            }
            if(map.containsKey(count)){
                Integer prevIndex = map.get(count);
                max = Math.max(max,i-prevIndex);
            }else{
                map.put(count,i);
            }

        }

        return max;
    }
}
