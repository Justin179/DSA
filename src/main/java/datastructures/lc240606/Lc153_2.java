package datastructures.lc240606;

public class Lc153_2 {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int m = l + (r-l)/2;
            if(m>0 && nums[m-1]>nums[m]){
                return nums[m];
            } else if (m<nums.length-1 && nums[m]>nums[r]) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return nums[l];
    }
}
