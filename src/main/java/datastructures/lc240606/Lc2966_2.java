package datastructures.lc240606;

import java.util.Arrays;

public class Lc2966_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11};
        int k = 14;
        divideArray(nums,k);
    }
    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length; // 9
        int[][] ans = new int[n/3][3];
        int row = 0;
        Arrays.sort(nums);
        for(int i = 0; i<n-2; i+=3){
            int a = nums[i];
            int b = nums[i+1];
            int c = nums[i+2];
            if(c-a > k){
                return new int[0][0];
            }
            ans[row][0] = a;
            ans[row][1] = b;
            ans[row][2] = c;
            row++;
        }
        return ans;
    }
}
