package datastructures.lc240212;

public class Lc209 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;
        int result = minSubArrayLen(target,nums);
        System.out.println(result);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int tempSum = 0;
        for(int i : nums){
            tempSum+=i;
        }
        if (tempSum<target){
            return 0;
        }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        for(int right = 0; right<nums.length; right++){
            currentSum+=nums[right];
            while(currentSum>=target){
                minLength = Math.min((right-left+1),minLength);

                currentSum-=nums[left];
                left++;
            }
        }

        return minLength;
    }
}
