package datastructures.lc240212;

import java.util.Stack;

public class Lc977 {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int[] res = new int[nums.length];
        int index = nums.length-1;
        while (l<=r){
            int left = nums[l]*nums[l];
            int right = nums[r]*nums[r];
            if(right>left){
                res[index] = right;
                r--;
            } else {
                res[index] = left;
                l++;
            }
            index--;
        }
        return res;
    }
}
