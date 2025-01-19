package datastructures.lc240606;

import java.util.HashMap;
import java.util.Map;

public class Lc2870 {
    public static void main(String[] args) {
        System.out.println(4%3); // 1
        System.out.println(3%3); // 0
        System.out.println(2%3); // 2
    }
    public int minOperations(int[] nums) {

        Map<Integer, Integer> mp = new HashMap<>();
        // [2,3,3,2,2,4,2,3,4]
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        /*
        2: 4  %3 1
        3: 3  %3 0
        4: 2  %3 2
         */

        int count = 0;

        for (var entry : mp.entrySet()) {
            int e = entry.getValue(); // 4

            if (e == 1)
                return -1;

            count += e / 3; // 1
            if (e % 3 != 0)
                count++;
        }
        return count;
    }
}
