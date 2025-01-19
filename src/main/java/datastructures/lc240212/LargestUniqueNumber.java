package datastructures.lc240212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestUniqueNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{397,513,784,485,253,360,924,37,97,624,743,203,406,77,23,123,748,309,230,669};
        largestUniqueNumber(nums);
    }

    public static int largestUniqueNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            set.add(num);
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer> allNums = new ArrayList<>();
        for(int num : set){
            allNums.add(num);
        }

        Collections.sort(allNums, Collections.reverseOrder());

        for(int num : allNums){
            if(map.get(num).intValue()==1){
                return num;
            }
        }
        return -1;
    }
}
