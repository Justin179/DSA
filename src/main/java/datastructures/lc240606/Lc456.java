package datastructures.lc240606;

import java.util.Stack;

// 1 3 2 pattern (中最大)
public class Lc456 {
    // 3 1 4 2
    public boolean find132pattern(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int cur_min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            while (!st.isEmpty() && curr >= st.peek()[0]) {
                st.pop();
            }

            if (!st.isEmpty() && curr > st.peek()[1]) {
                return true;
            }

            st.push(new int[] { curr, cur_min });
            cur_min = Math.min(cur_min, curr);
        }

        return false;
    }
}
