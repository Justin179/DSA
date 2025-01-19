package datastructures.lc240606;

import java.util.Arrays;

public class Lc179 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        largestNumber(nums);
    }

    public static String largestNumber(int[] nums) { // nums = [3,30,34,5,9]
        String[] arr = new String[nums.length]; // 5

        for(int i=0; i<nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (s1, s2) -> {
            String n1 = s1 + s2;
            String n2 = s2 + s1;
            return n2.compareTo(n1);
        });

        if(arr[0].equals("0")) // 9 5 34 3 30
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
