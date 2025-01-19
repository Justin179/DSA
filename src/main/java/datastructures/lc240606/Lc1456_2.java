package datastructures.lc240606;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lc1456_2 {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        Collections.addAll(set,'a','e','i','o','u');
        int L = 0;
        int count = 0;
        int max = 0;
        for(int R = 0; R < s.length(); R++){
            char cR = s.charAt(R);
            count += set.contains(cR)? 1 : 0;
            if(R-L+1 > k){
                char cL = s.charAt(L);
                count -= set.contains(cL)? 1 : 0;
                L++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
