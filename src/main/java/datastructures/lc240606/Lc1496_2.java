package datastructures.lc240606;

import java.util.HashSet;
import java.util.Set;

public class Lc1496_2 {
    public static void main(String[] args) {
        String path = "NESWW";
        isPathCrossing(path);
    }

    public static boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        char[] chars = path.toCharArray();
        int x = 0;
        int y = 0;
        for(char c : chars){
            switch(c){
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            String key = x+","+y;
            if(set.contains(key)){
                return true;
            }else{
                set.add(key);
            }
        }
        return false;
    }
}
