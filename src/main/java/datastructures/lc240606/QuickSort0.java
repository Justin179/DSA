package datastructures.lc240606;



import java.util.Random;

public class QuickSort0 {
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























