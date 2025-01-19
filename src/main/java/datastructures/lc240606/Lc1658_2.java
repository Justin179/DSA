package datastructures.lc240606;

import java.util.stream.IntStream;

public class Lc1658_2 {
    public int minOperations(int[] nums, int x) {
        int arrSum = IntStream.of(nums).sum();
        int target = arrSum - x; // 6
        if(target<0){
            return -1;
        }
        int sum = 0;
        int L = 0;
        int min = Integer.MAX_VALUE;
        for(int R = 0; R<nums.length; R++){
            sum += nums[R];
            while (sum > target){
                sum -= nums[L];
                L++;
            }
            if(sum==target){
                int curWinSize = R-L+1;
                int operation = nums.length - curWinSize;
                min = Math.min(min, operation);
            }
        }

        return min==Integer.MAX_VALUE? -1 : min;
    }
}
