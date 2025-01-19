package datastructures.lc240606;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc2610 {
    public List<List<Integer>> findMatrix(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) { //  [1,3,4,1,2,3,1]
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        /*
        1 3
        2 1
        3 2
        4 1
         */

        int maxFreq = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
            }
        }


        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < maxFreq; i++) { // 3
            List<Integer> childMatrix = new ArrayList<>();
            for (var entry : map.entrySet()) {
                if (entry.getValue() >= 1) {
                    childMatrix.add(entry.getKey());
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            matrix.add(childMatrix);
        }

        return matrix;
    }
}
