package datastructures.lc240606;

public class Lc162 {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int m = l + (r-l)/2;
            if(m>0 && nums[m-1] > nums[m]){ // 左大往左找
                r = m-1;
            } else if (m<nums.length-1 && nums[m] < nums[m+1]) { // 右大往右找
                l = m+1;
            } else {
                return m;
            }
        }
        return 0;
    }
}
