package datastructures.lc240212;

import java.util.HashMap;
import java.util.Map;

public class LC205 {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        boolean result = isIsomorphic(s,t);
    }

    public static boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character,Character> map = new HashMap<>();
        for(int i = 0; i<sChars.length; i++){
            map.put(sChars[i],tChars[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : sChars){
            char tChar = map.get(c);
            sb.append(tChar);
        }
        String str = sb.toString();
        if(str.equals(t)){
            return true;
        }else{
            return false;
        }

    }
}
