package datastructures.lc240212;

import java.util.ArrayList;
import java.util.List;

public class Lc145 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
            return list;
        dfs(root);
        return list;
    }
    void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.left);
        dfs(root.right);
        list.add(root.val);
    }
}
