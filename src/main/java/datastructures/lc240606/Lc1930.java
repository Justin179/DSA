package datastructures.lc240606;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc1930 {
    public int countPalindromicSubsequence(String s) { // aabca
        char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z'};
        Set<Character> left = new HashSet<>();
        Map<Character, Integer> right = new HashMap<>();
        for(char c : s.toCharArray()) { // aabca
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        Set<String> res = new HashSet<>();

        for(int mid = 0; mid < s.length(); mid++) { // 0 1 2 3 4 
            char c = s.charAt(mid);

            right.put(c, right.get(c)-1);
            if(right.get(c) == 0) {
                right.remove(c);
            }

            for(int i=0; i<26; i++) { // a - z
                if(left.contains(letters[i]) && right.containsKey(letters[i])) { // 左右一樣
                    res.add("" + letters[i] + c + letters[i]); // 找到存放
                }
            }

            left.add(c);
        }

        return res.size();
    }
}
