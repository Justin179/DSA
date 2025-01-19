package datastructures.lc240212;

public class Main {
    public static void main(String[] args) {
//        int[] nums = new int[]{-3,2,-3,4,2};
        // [-3,6,2,5,8,6]
        int[] nums = new int[]{-3,6,2,5,8,6};
        int minValue = minStartValue(nums);
        System.out.println(minValue);
    }

    public static int minStartValue(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int minValue = prefixSum[0]<0? prefixSum[0] : 1;
        for(int i = 1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
            minValue = Math.min(minValue, prefixSum[i]);
        }

        return minValue<0? Math.abs(minValue)+1 : minValue;
    }
}
