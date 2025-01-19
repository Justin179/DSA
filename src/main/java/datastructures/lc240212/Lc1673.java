package datastructures.lc240212;

import java.util.Arrays;
import java.util.Stack;

public class Lc1673 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,6};
        int k = 2;
        int[] ints = mostCompetitive(nums, k);
        System.out.println(ints);
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<nums.length; i++){
            int curr = nums[i];

            while(!stack.isEmpty() && stack.peek()>curr){
                stack.pop();
            }

            if(stack.isEmpty() || stack.size()<k){
                stack.push(curr);
            }
        }

        int n = stack.size();
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            ans[i] = stack.pop();
        }
        Arrays.sort(ans);
        return ans;
    }
}
