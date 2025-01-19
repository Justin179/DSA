package datastructures.lc240606;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequent(nums,k);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums){
            count.merge(num, 1, Integer::sum);
        }
        /*
        1:3次
        2:2次
        3:1次
         */
        List<Integer> bucket[] = new ArrayList[nums.length + 1];
        // 0 1 2 3 4 5 6次
        for(var entry : count.entrySet()){
            int times = entry.getValue();
            if(bucket[times]==null){
                bucket[times] = new ArrayList<>();
            }
            bucket[times].add(entry.getKey());
        }
        // 0 1 2 3 4 5 6次
        //   3 2 1
        List<Integer> ans = new ArrayList<>();

        for(int i = bucket.length-1; i>=0; i--){
            List<Integer> list = bucket[i];
            if(list==null || list.size()==0){
                continue;
            }else{
                for(Integer ele : list){
                    ans.add(ele);
                    if(ans.size()==k){
                        int[] arr = ans.stream().mapToInt(x -> x).toArray();
                        return arr;
                    }
                }
            }
        }
        return null;

//        for (int key : count.keySet()) {
//            int freq = count.get(key);
//            if (bucket[freq] == null){
//                bucket[freq] = new ArrayList<>();
//            }
//            bucket[freq].add(key);
//        }
//
//        int index = 0;
//        int[] res = new int[k];
//        for (int i = nums.length; i >= 0; i--) {
//            if (bucket[i] != null){
//                for (int val : bucket[i]) {
//                    res[index++] = val;
//                    if (index == k)
//                        return res;
//                }
//            }
//        }
//        return res;

    }
}
