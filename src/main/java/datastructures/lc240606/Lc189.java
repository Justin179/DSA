package datastructures.lc240606;

public class Lc189 {
    public static void main(String[] args) {
        System.out.println(3 % 7);
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
