package datastructures.lc240606;

public class Lc167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while (l<=r){
            int sum = numbers[l]+numbers[r];
            if(sum>target){
                r--;
            } else if(sum<target){
                l++;
            }else {
                return new int[]{l+1,r+1};
            }
        }

        return null;
    }
}
