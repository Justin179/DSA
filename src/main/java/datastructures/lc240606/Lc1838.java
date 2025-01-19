package datastructures.lc240606;

import java.util.Arrays;

public class Lc1838 {
    public int maxFrequency(int[] nums, int k) { // 1,4,8,13     k=5
        int max = 0; // Initialize the maximum frequency
        long currSum = 0; // Initialize the current sum of the subarray elements

        Arrays.sort(nums); // Sort the array in ascending order

        for (int L = 0, R = 0; R < nums.length; ++R) {
            currSum += nums[R]; // Include the current element in the subarray sum

            // Check if the current subarray violates the condition (sum + k < nums[R] * length)
            while (currSum + k < (long) nums[R] * (R - L + 1)) {
                currSum -= nums[L]; // Adjust the subarray sum by removing the leftmost element
                L++; // Move the L pointer to the R
            }

            // Update the maximum frequency based on the current subarray length
            max = Math.max(max, R - L + 1);
        }

        return max;
    }
}
