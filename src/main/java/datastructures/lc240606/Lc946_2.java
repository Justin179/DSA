package datastructures.lc240606;

import java.util.Stack;

public class Lc946_2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    // pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        Stack<Integer> stack = new Stack<>();

        int currPos = 0;
        for(int i : pushed){
            stack.push(i);
            while (!stack.isEmpty() && popped[currPos] == stack.peek()){
                stack.pop();
                currPos++;
            }
        }

        return stack.isEmpty();
    }
}
