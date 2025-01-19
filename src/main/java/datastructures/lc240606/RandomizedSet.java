package datastructures.lc240606;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    // Append to the end, maintain indexing
    // Delete by swapping with the end, maintain indexing
    // Get random by getting a random index wrt list's size
    public boolean insert(int val) {
        if(map.containsKey(val)) { // map中已經存在，不插
            return false;
        }

        int indexInsert = list.size();
        list.add(val);
        map.put(val, indexInsert);

        return true;
    }
    /*
    0 1 2 3
    1 2 3 4

    1:0
    2:1
    3:2
    4:3    試想現在要移掉2
     */
    public boolean remove(int val) { // 2
        if(!map.containsKey(val)) { // map中已經不在，不移
            return false;
        }

        int lastIndex = list.size() - 1; // 3

        int lastElement = list.get(lastIndex); // 拿到list中最後一個元素 4
        int valIndex = map.get(val); // 要移除的值的index 1

        // 1 拿list中最後的那個值去蓋要移除的
        list.set(valIndex, lastElement); // 1 4

        // 2 更新map, Update indices [Add & Delete]
        map.put(lastElement, valIndex);
        map.remove(val);

        // 3 移掉list最後一個元素，Remove from list
        list.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * list.size()); // 0.1 - 0.9 * 10
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
