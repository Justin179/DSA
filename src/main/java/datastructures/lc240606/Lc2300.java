package datastructures.lc240606;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // 預設小到大
        List<Integer> list = new ArrayList<>();
        for(int spell : spells){
            int idx = potions.length;
            int l = 0;
            int r = potions.length-1;
            while (l<=r){
                int m = l + (r-l)/2;
                if((long) spell *potions[m] >= success){
                    r = m-1;
                    idx = m;
                }else {
                    l = m+1;
                }
            }
            list.add(potions.length - idx);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
