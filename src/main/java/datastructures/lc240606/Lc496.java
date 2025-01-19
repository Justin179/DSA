package datastructures.lc240606;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lc496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,2,4};
        int[] nums2 = new int[]{6,5,4,3,2,1,7};
        int[] ans = nextGreaterElement(nums1, nums2);
        System.out.println(ans);
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(Integer i : nums2){ // 1 3 4 2
            while(!stack.isEmpty() && stack.peek()<i){
                 map.put(stack.pop(),i);
            }
            stack.push(i);
        }
        for(int i = 0; i<nums1.length; i++){
            int curr = nums1[i];
            if(map.containsKey(curr)){
                nums1[i] = map.get(curr);
            } else {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}
