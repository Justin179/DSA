package datastructures.lc240606;

import java.util.Arrays;

public class Lc1838_2 {
    public int maxFrequency(int[] nums, int k) { // 1,4,8,13     k=5
        Arrays.sort(nums);
        int L = 0;
        int max = 0;
        long currSum = 0;
        for(int R = 0; R<nums.length; R++){
            int target = nums[R];
            currSum += target;
            while (((R-L+1) * (long)target - currSum) > k){
                currSum -= nums[L];
                L++;
            }
            max = Math.max(max,R-L+1);
        }
        return max;
    }
}
