package datastructures.lc240606;

import java.util.Arrays;

public class Lc1968_2 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int[] ans = new int[nums.length];
        boolean flag = true;
        int i = 0;
        while(l<=r){
            if(flag){
                ans[i] = nums[l];
                l++;
            } else {
                ans[i] = nums[r];
                r--;
            }
            flag = !flag;
            i++;
        }
        return ans;
    }
}
