package datastructures.lc240606;

import java.util.Stack;

public class Lc20 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (char c : chars){

            boolean x = c==')' && !stack.isEmpty() && stack.peek()=='(';
            boolean y = c==']' && !stack.isEmpty() && stack.peek()=='[';
            boolean z = c=='}' && !stack.isEmpty() && stack.peek()=='{';
            if(x || y || z){
                stack.pop();
            } else {
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }
}
