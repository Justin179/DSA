package datastructures.lc240212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc1657 {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "bca";
        boolean result = closeStrings(word1,word2);
        System.out.println(result);

    }

    public static boolean closeStrings(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        if(chars1.length != chars2.length){
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char c : chars1){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(char c : chars2){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        if(!map1.keySet().equals(map2.keySet())){
            return false;
        }

        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }
}
