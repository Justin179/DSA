package datastructures.lc240212;

public class Lc543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if(root==null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int currMax = left+right;
        max = Math.max(max,currMax);
        return Math.max(left,right)+1;
    }
}
