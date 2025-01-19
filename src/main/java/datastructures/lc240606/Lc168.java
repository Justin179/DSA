package datastructures.lc240606;

import java.util.HashMap;
import java.util.Map;

public class Lc168 {

    public static void main(String[] args) {
        convertToTitle(28);
    }

    public static String convertToTitle(int columnNumber) {
        Map<Integer,Character> map = new HashMap<>();
        int a=64;
        for(int i = 1; i<=26; i++){
            char c=(char) (a+i);
            map.put(i,c);
        }
        float one = columnNumber/26.0f;
        if(one<=1.0){
            int key = columnNumber%26;
            return map.get(key).toString();
        } else {
            int first = columnNumber/26; // 1
            String left = map.get(first).toString();
            int second = columnNumber%26; // 2
            String right = map.get(second).toString();
            return left+right;
        }
    }


}
