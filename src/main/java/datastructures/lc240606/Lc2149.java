package datastructures.lc240606;

import java.util.LinkedList;
import java.util.Queue;

public class Lc2149 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,-2,-5,2,-4};
        int[] ints = rearrangeArray(nums);
        System.out.println(ints);
    }
    public static int[] rearrangeArray(int[] nums) {
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for(int i : nums){
            if(i>0){
                pos.add(i);
            }else {
                neg.add(i);
            }
        }
        for(int i =0; i<nums.length; i++){
            if(i%2==0){
                nums[i] = pos.poll();
            }else{
                nums[i] = neg.poll();
            }
        }

        return nums;
    }
}
