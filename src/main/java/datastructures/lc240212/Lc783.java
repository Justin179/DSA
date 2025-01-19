package datastructures.lc240212;

public class Lc783 {
    int min = Integer.MAX_VALUE;
    TreeNode pre;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }
    void dfs(TreeNode root){
        if (root==null)
            return;
        dfs(root.left);
        if(pre!=null)
            min = Math.min(min, root.val - pre.val);
        pre = root;
        dfs(root.right);
    }
}
