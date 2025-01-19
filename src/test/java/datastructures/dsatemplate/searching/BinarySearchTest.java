package datastructures.dsatemplate.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void search() {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        BinarySearch binarySearch = new BinarySearch();
        int targetIndex = binarySearch.search(nums, target);
        assertEquals(targetIndex,4);
    }

    // [-4,-1,0,3,10]
    // [0,1,9,16,100]
    @Test
    void squaresOfASortedArray() {
        int[] nums = new int[]{-4,-1,0,3,10};
        int[] results = sortedSquares(nums);
        assertArrayEquals(new int[]{0,1,9,16,100},results);
    }

    public int[] sortedSquares(int[] nums) {
        int[] nums2 = new int[nums.length];
        int L = 0;
        int R = nums.length-1;
        int backward = nums.length-1;
        while(L<=R){
            if(Math.abs(nums[L])<Math.abs(nums[R])){
                nums2[backward] = nums[R] * nums[R];
                R--;
            } else {
                nums2[backward] = nums[L] * nums[L];
                L++;
            }
            backward--;
        }
        return nums2;
    }

}
























