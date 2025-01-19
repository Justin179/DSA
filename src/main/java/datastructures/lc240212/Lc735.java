package datastructures.lc240212;

import java.util.Stack;

public class Lc735 {

    public static void main(String[] args) {
        int[] asteroids = new int[]{5,10,-5};
        int[] results = asteroidCollision(asteroids);
        System.out.println(results);
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<asteroids.length; i++){
            int curr = asteroids[i];
            if(stack.isEmpty()){
                stack.push(curr);
                continue;
            }
            if(!stack.isEmpty()){ // 同方向(不撞) || 反方向(不撞)
                boolean sameDirection = (stack.peek()>0 && curr>0) || (stack.peek()<0 && curr<0);
                boolean oppositeDirection = (stack.peek()<0 && curr>0);
                if(sameDirection || oppositeDirection){
                    stack.push(curr);
                }
            }

            while(!stack.isEmpty() && (stack.peek()>0 && curr<0)){ // 會撞
                int currAbs = Math.abs(curr);
                int topAbs = Math.abs(stack.peek());
                if(topAbs<currAbs){ // top 小
                    stack.pop();
                } else if(topAbs>currAbs){ // top 大
                    break;
                } else { // 一樣大
                    stack.pop();
                }
            }

        }

        int[] ans = new int[stack.size()]; // 2
        for(int i = stack.size()-1; i>=0; i--){ // 1 0
            ans[i] = stack.pop();
        }
        return ans;
    }
}
