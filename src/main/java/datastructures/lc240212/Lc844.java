package datastructures.lc240212;

import java.util.Stack;

public class Lc844 {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        backspaceCompare(s,t);
    }

    public static boolean backspaceCompare(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for(char c : charsS){
            if(c=='#' && !stackS.isEmpty()){
                stackS.pop();
            }
            if(c!='#'){
                stackS.push(c);
            }
        }

        for(char c : charsT){
            if(c=='#' && !stackT.isEmpty()){
                stackT.pop();
            }
            if(c!='#'){
                stackT.push(c);
            }
        }

        String strS = "";
        while(!stackS.isEmpty()){
            strS += stackS.pop();
        }
        String strT = "";
        while(!stackT.isEmpty()){
            strT += stackT.pop();
        }

        if(strS.equals(strT)){
            return true;
        } else {
            return false;
        }

    }
}
