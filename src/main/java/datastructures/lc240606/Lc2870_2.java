package datastructures.lc240606;

import java.util.HashMap;

public class Lc2870_2 {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        int operations = 0;
        for (int val : nums) {
            fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        }
                /*
        2: 4  %3 1
        3: 3  %3 0
        4: 2  %3 2
         */
        for (int key : fmap.keySet()) {
            if (fmap.get(key) == 1) {
                return -1;
            } else if (fmap.get(key) % 3 == 0) {
                operations += (fmap.get(key) / 3);
            } else {
                operations += (fmap.get(key) / 3) + 1;
            }
        }
        return operations;
    }
}
