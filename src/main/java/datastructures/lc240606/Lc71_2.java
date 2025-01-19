package datastructures.lc240606;

import java.util.Stack;

public class Lc71_2 {
    public static void main(String[] args) {
     simplifyPath("/../");
    }
    public static String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str : strings){
            if(str.isEmpty() || str.equals(".")){
                continue;
            } else if (str.equals("..")) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        return "/" + String.join("/",stack);
    }
}
