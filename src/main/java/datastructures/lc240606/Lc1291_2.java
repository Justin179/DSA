package datastructures.lc240606;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc1291_2 {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i<s.length()-1; i++){ // 0 - 7
            for(int j = i+1; j<s.length(); j++){ // 1 - 8
                String substring = s.substring(i, j + 1);
                int currNum = Integer.parseInt(substring);
                if(currNum>high){
                    break;
                }
                if(currNum>=low){
                    res.add(currNum);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
