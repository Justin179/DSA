package datastructures.lc240606;

public class Lc665 {
    public boolean checkPossibility(int[] nums) { // 4 2 3
        boolean changed = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i+1])
                continue;

            if (changed)
                return false;

            if (i == 0 || nums[i+1] >= nums[i-1])
                nums[i] = nums[i+1];
            else
                nums[i+1] = nums[i];

            changed = true;
        }

        return true;
    }
}
