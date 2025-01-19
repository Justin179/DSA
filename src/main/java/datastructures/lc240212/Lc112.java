package datastructures.lc240212;

public class Lc112 {
    int target = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        target = targetSum;
        return dfs(root,0);
    }

    boolean dfs(TreeNode root, int currSum){
        if(root==null)
            return false;
        currSum += root.val; // 22
        if(root.left==null && root.right==null && currSum==target){
            return true;
        }
        boolean left = dfs(root.left,currSum);
        boolean right = dfs(root.right,currSum);
        return left || right;
    }
}
