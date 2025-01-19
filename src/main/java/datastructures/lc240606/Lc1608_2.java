package datastructures.lc240606;

import java.util.Arrays;

 // In java array i sort decreasing order
// then perform same operations in reverse
// you can sort arry in non decreasing order using collections
//Arrays.sort(numsInteger, Collections.reverseOrder())
public class Lc1608_2 {
     public int specialArray(int[] nums) {
         Arrays.sort(nums);
         int n = nums.length;

         if (nums[0] >= n)
             return n;

         for (int i = 1; i <= n; i++) { // 1 2 3 4 5 
             if (nums[n - i] >= i && (n - i - 1 < 0 || nums[n - i - 1] < i)) {
                 return i;
             }
         }

         return -1;
     }
}
