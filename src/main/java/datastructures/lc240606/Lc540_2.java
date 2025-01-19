package datastructures.lc240606;

public class Lc540_2 {
    public static void main(String[] args) {
        singleNonDuplicate(new int[]{1,1,2,3,3});
    }
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int m = l + (r-l)/2;
            // m奇=左奇&右奇
            // m偶=左偶&右偶
            if((m>0&&nums[m]!=nums[m-1])&&((m<nums.length-1)&&(nums[m]!=nums[m+1]))){
                return nums[m];
            }
            if((m%2==1 && nums[m] == nums[m-1]) || (m%2==0 && nums[m]==nums[m+1])){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return nums[l];
    }
}
