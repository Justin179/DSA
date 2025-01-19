package datastructures.lc240212;

public class Lc110 {
    int max = 0;
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        dfs(root);
        return max<=1;
    }
    int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(Math.abs(left-right),max);
        return Math.max(left,right)+1;
    }
}
