package datastructures.lc240606;

import java.util.Stack;

public class Lc946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    // pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        Stack<Integer> st = new Stack<>(); // Create a stack

        int j = 0; // Intialise one pointer pointing on popped array

        for(int val : pushed){
            st.push(val); // insert the values in stack
            while(!st.isEmpty() && st.peek() == popped[j]){ // if st.peek() values equal to popped[j];
                st.pop(); // then pop out
                j++; // increment j
            }
        }
        return st.isEmpty(); // check if stack is empty return true else false
    }
}
