package datastructures.lc240606;



import java.util.Random;

public class QuickSort1 {
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
    // 1 8 3 9 4 5 7
    private static void quickSort(int[] nums, int lowIndex, int highIndex) {
        if(lowIndex>=highIndex){
            return;
        }

        int pivotVal = nums[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex-1;

        while(leftPointer < rightPointer){
            while (nums[leftPointer]<=pivotVal && leftPointer<rightPointer){
                leftPointer++;
            }
            while (nums[rightPointer]>=pivotVal && leftPointer<rightPointer){
                rightPointer--;
            }
            swap(nums,leftPointer,rightPointer);
        }

        swap(nums,leftPointer,highIndex);

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























