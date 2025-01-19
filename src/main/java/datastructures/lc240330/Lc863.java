package datastructures.lc240330;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Lc863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ret = new ArrayList<>();
        if (k == 0) {
            ret.add(target.val);
            return ret;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        treeToGraph(root, graph);

        Queue<Integer> q = new LinkedList<>();
        q.add(target.val);
        List<Integer> visited = new ArrayList<>();
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int s = q.poll();
                visited.add(s);
                for (int i : graph.getOrDefault(s, new ArrayList<>())) { // 掃周
                    if (!visited.contains(i)) {
                        q.add(i);
                        if (level == k) {
                            ret.add(i);
                        }
                    }
                }
            }
            if (level == k)
                return ret;
            level++;
        }
        return ret;
    }

    // 重要
    private void treeToGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root == null)
            return;

        if (root.left != null) {
            // 如果key不存在，就new一個list，list.add(int)
            // 如果key已存在，就拿出該list，list.add(int)
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
        }
        if (root.right != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
        }

        treeToGraph(root.left, graph);
        treeToGraph(root.right, graph);
    }
}
