package datastructures.lc240606;

import java.util.Arrays;

public class Lc1968 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums); // 1 2 3 4 5
        int n = nums.length;
        int[] ans = new int[n];
        boolean flag = true;
        int i = 0;
        int k = 0;
        int j = n - 1;
        while (i <= j) {
            ans[k++] = flag ? nums[i++] : nums[j--];
            flag = !flag;
        }
        return ans;
    }
}
