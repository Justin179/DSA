package datastructures.lc240606;

import java.util.Stack;

public class Lc2390 {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c!='*'){ // 字母
                stack.push(c);
            }else if(stack.isEmpty()){
                // c=='*' && stack is empty
            } else { // c=='*' && stack is not empty
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}
