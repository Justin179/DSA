package datastructures.lc240330;

import java.util.HashMap;
import java.util.Map;

public class Lc437 {
    // Map for keeping track of (PrefixSum, timesPrefixSumSeen) during traversal
    Map<Long, Integer> hmap;
    int count;

    public int pathSum(TreeNode root, int targetSum) {
        hmap = new HashMap<>();
        count = 0;

        dfs(root, 0, targetSum);

        return count;
    }

    private void dfs(TreeNode root, long prefixSum, int targetSum) { // root, 0, 8
        // base case
        if (root == null) return;


        prefixSum += root.val;

        // If map contains a sum equal to (prefixSum - targetSum), we need to increment count that many times
        if (hmap.containsKey(prefixSum-targetSum)) {
            count += hmap.get(prefixSum-targetSum);
        }

        // There can be cases when the prefixSum is directly equal to targetSum, we need to increment count
        if (targetSum == prefixSum) {
            count++;
        }

        // Update the prefixSum till current node and it's count
        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

        // Recurse
        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);

        // Backtrack
        hmap.put(prefixSum, hmap.get(prefixSum) - 1);

    }
}









