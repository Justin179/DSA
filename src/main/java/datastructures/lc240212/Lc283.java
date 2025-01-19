package datastructures.lc240212;

public class Lc283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        if(nums.length==1){
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0){
                for(int j = i+1; j<nums.length; j++){
                    if(nums[j]!=0){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }
}
