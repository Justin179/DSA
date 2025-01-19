package datastructures.lc240212;

import java.util.Stack;

public class Lc1944 {
    public static void main(String[] args) {
        int[] heights = new int[]{10,6,8,5,11,9};
        int[] ints = canSeePersonsCount(heights);
        System.out.println(ints);
    }

    public static int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];
        for(int i = heights.length-1; i>=0; i--){
            int count = 0;
            int currHeight = heights[i];
            while(!stack.isEmpty() && currHeight > stack.peek()){
                count++;
                stack.pop();
            }
            if(!stack.isEmpty()){
                count++;
            }
            stack.push(currHeight);
            ans[i] = count;
        }
        return ans;
    }
}
