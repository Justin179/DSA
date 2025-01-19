package datastructures.lc240606;

import java.util.ArrayList;
import java.util.List;

public class Lc22_2 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }
    void backtrack(List<String> result, String currStr, int open, int close, int n){
        if(currStr.length()==n*2){
            result.add(currStr);
            return;
        }
        // go left
        if(open<n){
            backtrack(result,currStr+"(",open+1,close,n);
        }
        // go right
        if(close<open){
            backtrack(result,currStr+")",open,close+1,n);
        }
    }

}
