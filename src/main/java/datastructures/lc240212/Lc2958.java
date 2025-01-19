package datastructures.lc240212;

import java.util.HashMap;
import java.util.Map;

public class Lc2958 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3,1,2};
        int k = 2;
        int result = maxSubarrayLength(nums,k);
    }

    public static int maxSubarrayLength(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        int maxLength = 0;

        int i = 0;
        for(int j = 0; j<nums.length; j++){
            int currNum = nums[j];
            map.put(currNum,map.getOrDefault(currNum,0)+1);

            while(map.getOrDefault(currNum,0).intValue()>k){
                int iNum = nums[i];
                map.put(iNum,map.get(iNum).intValue()-1);
                i++;
            }

            int currLength = j - i + 1;
            maxLength = Math.max(maxLength,currLength);
        }

        return maxLength;
    }
}
