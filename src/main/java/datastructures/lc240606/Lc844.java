package datastructures.lc240606;

import java.util.Stack;

public class Lc844 {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        backspaceCompare(s,t);
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(char c : s.toCharArray()){
            if(s1.isEmpty() && c=='#'){
                continue;
            }

            if(!s1.isEmpty() && c=='#'){
                s1.pop();
            } else {
                s1.push(c);
            }
        }
        for(char c : t.toCharArray()){
            if(s2.isEmpty() && c=='#'){
                continue;
            }

            if(!s2.isEmpty() && c=='#'){
                s2.pop();
            } else {
                s2.push(c);
            }
        }
        return s1.equals(s2);
    }
}
