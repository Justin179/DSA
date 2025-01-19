package datastructures.lc240606;

public class Lc209 {
    public static void main(String[] args) {

    }
    public int minSubArrayLen(int target, int[] nums) { // target = 7, nums = [2,3,1,2,4,3]
        int minLeng = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            while (sum>=target){
                int currLeng = i+1-left;
                minLeng = Math.min(minLeng,currLeng);
                sum-=nums[left];
                left++;
            }
        }
        return minLeng==Integer.MAX_VALUE? 0:minLeng;
    }
}
