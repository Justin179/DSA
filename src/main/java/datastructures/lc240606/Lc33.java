package datastructures.lc240606;

public class Lc33 {
    public static void main(String[] args) {
        search(new int[]{5,1,3},1);
    }
    public static int search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target)
                return 0;
            else
                return -1;
        }
        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int m = l +(r-l)/2;
            if(nums[m]>nums[r]){
                l = m+1;
            }else {
                r = m;
            }
        }
        int minIndex = l;
        l = 0;
        r = nums.length-1;
        if (target>=nums[minIndex] && target<=nums[r]){
            l = minIndex;
        } else {
            r = minIndex-1;
        }

        while (l<r){
            int m = l + (r-l)/2;
            if(target==nums[m]){
                return m;
            } else if (target>nums[m]) {
                l = m+1;
            }else {
                r = m-1;
            }
        }

        return nums[l]==target? l:-1;
    }
}
