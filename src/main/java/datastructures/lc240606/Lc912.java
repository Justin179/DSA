package datastructures.lc240606;

import java.util.ArrayList;

public class Lc912 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        int[] ints = sortArray(nums);
        System.out.println(ints);
    }
    //Using Merge Sort
    public static int[] sortArray(int[] nums) {
        divideAndMerge(nums, 0, nums.length-1);
        return nums;
    }

    public static void divideAndMerge(int[] arr, int low, int high){
        if(low >= high) // base case 為low high交疊 也就是只有一個元素時
            return;

        int mid = (low+high)/2; // 1
        divideAndMerge(arr, low, mid); // 0 1
        divideAndMerge(arr, mid+1, high); // 2 3

        merge(arr, low, high, mid); // 0 1 0
    }

    public static void merge(int[] arr, int low, int high, int mid){ // 0 1 0
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low; // left pointer
        int right = mid+1; // right pointer

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<= high; i++){ // 2 3
            arr[i] = temp.get(i-low);
        }
    }
}

