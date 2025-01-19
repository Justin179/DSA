package datastructures.lc240606;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc438 {
    public List<Integer> findAnagrams(String s, String p) {

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
        int startIndex = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) { // cbaebabacd
            sMap.put(s.charAt(i), 1 + sMap.getOrDefault(s.charAt(i), 0));

            if(i >= p.length() - 1) {
                if(sMap.equals(pMap))
                    res.add(startIndex);

                //if current character is in sMap, remove it and re-update the map.
                if(sMap.containsKey(s.charAt(startIndex))) {
                    sMap.put(s.charAt(startIndex), sMap.get(s.charAt(startIndex)) - 1);
                    if(sMap.get(s.charAt(startIndex)) == 0)
                        sMap.remove(s.charAt(startIndex));
                }
                startIndex += 1;
            }
        }

        return res;
    }
}

