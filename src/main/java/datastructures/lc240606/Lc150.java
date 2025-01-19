package datastructures.lc240606;

import java.util.Stack;

public class Lc150 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int n2 = stack.pop();
                int n1 = stack.pop();
                switch (str){
                    case "+":
                        stack.push(n1+n2);
                        break;
                    case "-":
                        stack.push(n1-n2);
                        break;
                    case "*":
                        stack.push(n1*n2);
                        break;
                    case "/":
                        stack.push(n1/n2);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }

        return stack.pop();
    }
}
