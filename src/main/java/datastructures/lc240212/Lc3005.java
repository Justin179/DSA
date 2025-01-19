package datastructures.lc240212;

import java.util.HashMap;
import java.util.Map;

public class Lc3005 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,1,4};
        int result = maxFrequencyElements(nums);
    }

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max = 0;
        for(var entry : map.entrySet()){
            int currFrequency = entry.getValue().intValue();
            max = Math.max(max, currFrequency);
        }
        int sum = 0;
        for(var entry : map.entrySet()){
            if(entry.getValue().intValue() == max){
                sum += entry.getValue().intValue();
            }
        }
        return sum;
    }
}
