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
class Lc863_2 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ret = new ArrayList<>();
        if (k == 0) {
            ret.add(target.val);
            return ret;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        treeToGraph(root, graph);

        List<Integer> result = new ArrayList<>();

        Set<Integer> seen = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target.val);

        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size(); // 1  3(3 6 2)
            distance++; // 2

            for(int i = 0; i < size; ++i) { //
                int curr = queue.poll(); // 5

                seen.add(curr); // 5 3 6 2 (必須得在轉之前加，不然就無限循環)

                for(Integer val : graph.get(curr)) {  // 3 6 2
                    if(!seen.contains(val)) {
                        if(distance == k){
                            result.add(val);
                        }
                        queue.offer(val); // 3 6 2 (下層的加進queue)
                    }
                }
            }

            if(distance == k)
                return result;
        }

        return result;
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
