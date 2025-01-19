package datastructures.lc240606;

import java.util.ArrayList;
import java.util.List;

public class Lc1470 {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){ // 轉3次
            list.add(nums[i]);
            list.add(nums[i+n]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
