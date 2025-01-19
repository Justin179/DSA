package datastructures.lc240212;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc1438 {
    public static void main(String[] args) {
        int[] nums = new int[]{8,2,4,7};
        int limit = 4;
        int result = longestSubarray(nums,limit);
        System.out.println(result);
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> decreasing = new ArrayDeque<>();
        Deque<Integer> increasing = new ArrayDeque<>();

        int n = nums.length;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right<n){
            int valR = nums[right];
            // decreasing queue, 最大的會在左邊
            // increasing queue, 最小的會在左邊
            while(!decreasing.isEmpty() && decreasing.getLast()<valR){
                decreasing.removeLast();
            }
            decreasing.addLast(valR);

            while(!increasing.isEmpty() && increasing.getLast()>valR){
                increasing.removeLast();
            }
            increasing.addLast(valR);


            while( decreasing.getFirst()-increasing.getFirst() >limit){ // 不合規，則左側縮
                left++;
            }

            // 能走到此的，就是合規的left right
            int currLength = right - left + 1;
            maxLength = Math.max(currLength,maxLength);

            right++;
        }
        return maxLength;
    }
}
