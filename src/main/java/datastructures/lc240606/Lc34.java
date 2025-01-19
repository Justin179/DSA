package datastructures.lc240606;

public class Lc34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirstIndex(nums,target);
        res[1] = findLastIndex(nums,target);
        return res;
    }

    private int findFirstIndex(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int m = l+(r-l)/2;
            if(target<=nums[m]){ // 往左試著找出另一個==
                r = m-1;
            }else {
                l = m+1;
            }
            if(nums[m]==target)
                index = m;
        }

        return index;
    }
    private int findLastIndex(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int m = l+(r-l)/2;
            if(target>=nums[m]){ // 往右試著找出另一個==
                l = m+1;
            }else {
                r = m-1;
            }
            if(nums[m]==target)
                index = m;
        }

        return index;
    }

}
