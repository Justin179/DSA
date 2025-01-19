package datastructures.hashmap;

import java.util.*;


public class Main {

    // WRITE THE FINDDUPLICATES METHOD HERE //
    public static List<Integer> findDuplicates(int[] nums){
        List<Integer> list = new ArrayList<>();
        Map<Integer,Boolean> map = new HashMap<>();

        map.forEach((k,v)->{
            
        });

        for (int i = 0;i<nums.length ;i++ ) {
            int num = nums[i];
            Boolean value = map.get(num);
            if(value==null){
                map.put(num,true);
            }else {
                boolean contains = list.contains(num);
                if(!contains){
                    list.add(num);
                }
            }
        }
        return list;
    }



    public static void main(String[] args) {

//        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        int[] nums = {1, 1,1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */

    }

}
