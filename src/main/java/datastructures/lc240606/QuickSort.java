package datastructures.lc240606;



import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random rand = new Random();
        for(int i = 0; i<nums.length; i++){
            nums[i] = rand.nextInt(100); // 0-99
        }
        printArray(nums,"Before:");
        quickSort(nums,0,nums.length-1);
        printArray(nums,"After:");
    }

    // 對指定範圍進行quick sort
    private static void quickSort(int[] nums, int lowIndex, int highIndex) {
        // 0. base case (no need to sort a single number)
        if(lowIndex>=highIndex){ // must be >=
            return;
        }

        // 1. use last number as a pivot
        int pivotVal = nums[highIndex];

        // 2. 比pivot小的放左邊; 比pivot大的放右邊
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while(leftPointer < rightPointer){
            while (nums[leftPointer] <= pivotVal && leftPointer < rightPointer){ // 左邊的<=pivot -> pass，右移1格 (point最後會停留在該swap的地方)
                leftPointer++;
            }
            while (nums[rightPointer] >= pivotVal && leftPointer < rightPointer){ // 右邊的>=pivot -> pass，左移1格 (point最後會停留在該swap的地方)
                rightPointer--;
            }
            swap(nums,leftPointer,rightPointer);
        }
        // swap leftPointer & highIndex，之後pivot左側全小於pivotVal, pivot右側全大於pivotVal
        swap(nums,leftPointer,highIndex);

        // 對該pivot左邊的做遞迴; 對該pivot右邊的做遞迴
        quickSort(nums,lowIndex,leftPointer-1);
        quickSort(nums,leftPointer+1,highIndex);
    }

    private static void swap(int[] nums, int leftPointer, int rightPointer) {
        int temp = nums[leftPointer];
        nums[leftPointer] = nums[rightPointer];
        nums[rightPointer] = temp;
    }

    private static void printArray(int[] num, String str) {
        System.out.println(str);
        for(int i : num){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }
}























