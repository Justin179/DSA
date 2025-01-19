package datastructures.lc240606;

public class Lc153 {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2){
            if(nums[0]<nums[1])
                return nums[0];
            else
                return nums[1];
        }

        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int m = l + (r-l)/2;
            if(m>0 && nums[m-1] > nums[m]){
                return nums[m];
            }else if(nums[l]<=nums[m] && nums[m]>nums[r]){
                l = m+1;
            }else {
                r = m-1;
            }
        }
        return nums[l];
    }
}
