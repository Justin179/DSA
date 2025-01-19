package datastructures.lc240606;

import java.util.Stack;

// 1 3 2 pattern (中最大)
public class Lc456_2 {
    // 3 1 4 2
    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int currMin = nums[0];
        for(int i = 1; i<nums.length; i++){
            int curr = nums[i];
            while (!stack.isEmpty()&&curr>=stack.peek()[0])
                stack.pop();
            if(!stack.isEmpty()&&curr>stack.peek()[1])
                return true;
            stack.push(new int[]{curr,currMin});
            currMin = Math.min(curr,currMin);
        }

        return false;
    }
}
