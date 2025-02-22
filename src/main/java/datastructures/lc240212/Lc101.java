package datastructures.lc240212;

public class Lc101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }
    boolean dfs(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
