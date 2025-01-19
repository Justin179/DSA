package datastructures.lc240606;

public class Lc268 {
    public int missingNumber(int[] nums) {
        int length = nums.length; // 3
        int result = 0;
        for(int i = 0; i<length; i++){
            result += i-nums[i];
        }
        result += length;
        return result;
    }
}
