package datastructures.lc240606;

import java.util.HashSet;
import java.util.Set;

public class Lc219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) { // 1 2 3 1   2

        Set<Integer> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            if (set.size() > k) {
                set.remove(nums[left]);
                left++;
            }

            if (set.contains(nums[right])) { // 範圍內含
                return true;
            }

            set.add(nums[right]);
        }

        return false;
    }
}
