package datastructures.lc240212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc49 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                List<String> Strings = map.get(key);
                Strings.add(str);
                map.put(key, Strings);
            }
        }

        List<List<String>> results = new ArrayList<>();
        for(var entry : map.entrySet()){
            results.add(entry.getValue());
        }

        return results;
    }
}
