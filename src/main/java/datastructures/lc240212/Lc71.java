package datastructures.lc240212;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc71 {

    public static void main(String[] args) {
        String path = "/../";
        String result = simplifyPath(path);

    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] strArr = path.split("/");

        for(String str : strArr){
            if(str.equals("..") && !stack.isEmpty()){
                stack.pop();
                continue;
            }
            if(str.equals("") || str.equals(".") || (str.equals("..") && stack.isEmpty())){
                continue;
            }
            stack.push(str);
        }

        List<String> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder("/");
        for(int i = list.size()-1; i>=0; i--){
            String str = list.get(i);
            sb.append(str);
            if(i!=0){
                sb.append("/");
            }
        }

        return sb.toString();
    }
}
