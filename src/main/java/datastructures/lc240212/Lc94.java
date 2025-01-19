package datastructures.lc240212;

import java.util.ArrayList;
import java.util.List;

public class Lc94 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }
    void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
