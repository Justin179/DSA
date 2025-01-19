package datastructures.lc240606;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // Sort the array
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        //  0  1  2 3 4 5
        //     l        r

        for (int i = 0; i < nums.length - 2; i++) {
            if(i>0 && nums[i]==nums[i-1]){ // 防-1 -1
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            int targetSum = 0-nums[i]; // 4
            while(l<r){
                int tempSum = nums[l]+nums[r];
                if( tempSum == targetSum){
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    ans.add(list);
                    while (l<r && nums[l]==nums[l+1]){
                        l++;
                    }
                    while (l<r && nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                } else if (tempSum > targetSum) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return ans;
    }
}
