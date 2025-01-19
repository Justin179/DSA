package datastructures.dsatemplate.searching;

public class BinarySearch {

    /*
        check templates for
        1 finding the min value index
        2 BST
     */
    public int search(int[] nums, int target) {

        return 0;
    }

    public int solution(int[] nums, int target) {
        // 先找到最小數字的index
        int left = 0;
        int right = nums.length - 1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        int start = left; // 4
        left = 0;
        right = nums.length-1;
        // 從這裡較正一次
        if(target>=nums[start] && target <= nums[right]){
            left = start;
        } else {
            right = start-1;
        }
        // 之後就是套版
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid]<target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}
