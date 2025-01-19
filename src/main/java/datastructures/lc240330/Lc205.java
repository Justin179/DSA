package datastructures.lc240330;

import java.util.HashMap;
import java.util.Map;

public class Lc205 {
    public static void main(String[] args) {
        isIsomorphic("badc","baba");
    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            Character temp = map.get(a);
            if(temp==null){
                map.put(a,b);
            }else{
                if(temp!=b){
                    return false;
                }
            }
        }

        Map<Character,Character> map2 = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char a = t.charAt(i);
            char b = s.charAt(i);
            Character temp = map2.get(a);
            if(temp==null){
                map2.put(a,b);
            }else{
                if(temp!=b){
                    return false;
                }
            }
        }

        return true;
    }
}
