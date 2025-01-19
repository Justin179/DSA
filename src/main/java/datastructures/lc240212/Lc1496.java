package datastructures.lc240212;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lc1496 {
    public static void main(String[] args) {
        String path = "NNSWWEWSSESSWENNW";
        boolean result = isPathCrossing(path);
        System.out.println(result);
    }

    public static boolean isPathCrossing(String path) {
        char[] chars = path.toCharArray();
        int[] box = new int[]{0,0};
        String starting = Arrays.toString(box);
        Set<String> set = new HashSet<>();
        set.add(starting);

        for(char c : chars){
            switch(c){
                case 'N':
                    box[1] = box[1] + 1;
                    break;
                case 'E':
                    box[0] = box[0] + 1;
                    break;
                case 'S':
                    box[1] = box[1] - 1;
                    break;
                case 'W':
                    box[0] = box[0] - 1;
                    break;
            }
            String currStr = Arrays.toString(box);
            if(set.contains(currStr)){
                return true;
            }else{
                set.add(currStr);
            }
        }

        return false;
    }
}
