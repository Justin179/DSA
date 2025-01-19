package datastructures.lc240212;

public class Lc930 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,0,1};
        int goal = 2;
        int result = numSubarraysWithSum(nums,goal);

    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0;
        int sum = 0;
        int counter = 0;
        for(int j = 0; j<nums.length; j++){
            sum += nums[j]; // sum = 1
            // over the limit, cut off i
            while(sum>goal || nums[i]==0){
                sum-=nums[i];
                i++;
            }
            // 合規
            if(sum==2){
                counter++;
            }
        }
        return counter;
    }
}
