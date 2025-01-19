package datastructures.lc240606;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc438_2 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        findAnagrams(s,p);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length()>s.length()){
            return res;
        }

        Map<Character, Integer> pMap = new HashMap<>();
        for(char c: p.toCharArray()){
            pMap.put(c, 1 + pMap.getOrDefault(c, 0));
        }
        /*
            a 1
            b 1
            c 1
         */
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i<p.length(); i++){ // 0 1 2
            char c = s.charAt(i);
            sMap.put(c, 1 + sMap.getOrDefault(c, 0));
        }
        if(sMap.equals(pMap)){
            res.add(0);
        }

        for(int i = 1; i<=(s.length()-p.length()); i++){
            int prevIndex = i-1; // 0
            int newIndex = prevIndex + p.length(); // 3
            char prevChar = s.charAt(prevIndex);
            char newChar = s.charAt(newIndex);
            // 去舊
            if(sMap.containsKey(prevChar)){
                int remain = sMap.get(prevChar) - 1;
                if(remain==0){
                    sMap.remove(prevChar);
                } else {
                    sMap.put(prevChar,remain);
                }
            }
            // 入新
            sMap.put(newChar,sMap.getOrDefault(newChar,0)+1);
            if(sMap.equals(pMap)){
                res.add(i);
            }
        }

        return res;
    }
}

