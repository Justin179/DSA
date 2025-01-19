package datastructures.lc240212;

import java.util.ArrayList;
import java.util.List;

public class Lc872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        dfs(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        dfs(root2,list2);
        return list1.equals(list2);
    }
    void dfs(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        dfs(root.left, list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        dfs(root.right, list);
    }
}
