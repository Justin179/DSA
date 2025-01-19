package datastructures.lc240606;

import java.util.HashSet;

public class Lc3 {
    public int lengthOfLongestSubstring(String s) { // abcabcbb
        int max = 0;
        int L = 0;
        int R = 0;
        HashSet<Character> set = new HashSet<>();
        while(R<s.length()){
            char curr = s.charAt(R);
            while(set.contains(curr)){
                set.remove(s.charAt(L));
                L++;
            }
            set.add(curr);
            max = Math.max(max,(R-L+1));
            R++;
        }

        return max;
    }
}
