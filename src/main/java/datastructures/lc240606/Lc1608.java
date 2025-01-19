package datastructures.lc240606;

import java.util.Arrays;
/*
    Find the smallest value of x that makes the array special by using binary search on the sorted array,
    minimizing the search space at each step based on the count of elements greater than or equal to the current midpoint
    value. This approach significantly reduces the time complexity compared to a linear search through all
    possible values of x
 */
public class Lc1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums); // 0 0 3 4 4

        int start = 0;
        int end = nums.length; // 5

        while(start<=end){

            int mid = start+ (end-start)/2; // 2
            int ans = count(nums, mid); // 3

            if (ans == mid)  // mid 2 , ans 3
                return mid;
            else if (ans > mid)
                start = mid + 1;
            else
                end = mid - 1;


        }

        return -1;
    }
    int count(int[] nums, int target){ // target為2
        int ans = 0;
        for(int num : nums){
            if(num>=target)
                ans++;
        }
        return ans;
    }


}
