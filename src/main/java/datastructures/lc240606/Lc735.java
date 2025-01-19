package datastructures.lc240606;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc735 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,-1,1,-2};
        asteroidCollision(ints);
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i : asteroids){
            // -4 5
            // 4 5
            if(stack.isEmpty() || i>0 || (stack.peek()<0 && i<0)){
                stack.push(i);
                continue;
            }

            boolean next = false;
            while (!stack.isEmpty() && stack.peek()>0 && i<0){ // 會相撞的情況 (正 負 才會相撞)
                int diff = stack.peek() + i;
                if(diff<0){ // 右大
                    stack.pop();
                } else if (diff>0) {
                    break;
                } else {
                    stack.pop();
                    next = true;
                    break;
                }
            }

            if(next)
                continue;

            if(stack.isEmpty() || (stack.peek() < 0 && i < 0) ){
                stack.push(i);
            }


        }

        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(0,stack.pop());
        }
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
