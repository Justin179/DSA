package datastructures.lc240606;

public class Lc540 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;

            /*
                m奇數意味著 左奇 右奇，此時如果左同(左-1就變偶數)，那就只能走右
                m偶數意味著 左偶 右偶，此時右果右同(右-1就變奇數)，那就只能走右
             */
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) ||
                    (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                left = mid + 1;
            else
                right = mid;

        }
        return nums[left];
    }
}
