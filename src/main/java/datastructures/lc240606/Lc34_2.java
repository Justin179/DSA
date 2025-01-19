package datastructures.lc240606;

public class Lc34_2 {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return new int[]{-1,-1};
        int leftIndex = binarySearch(nums,target,true);
        int rightIndex = binarySearch(nums,target,false);
        return new int[]{leftIndex,rightIndex};
    }

    private int binarySearch(int[] nums, int target, boolean goLeft) {
        int l = 0;
        int r = nums.length-1;
        int index = -1;
        while (l<=r){
            int m = l+(r-l)/2;
            int curr = nums[m];
            if(target>curr){
                l = m+1;
            } else if (target<curr) {
                r = m-1;
            }else {
                index = m; // 找到了先存下
                if(goLeft){
                    r = m-1;
                }else {
                    l = m+1;
                }
            }
        }
        return index;
    }
}
