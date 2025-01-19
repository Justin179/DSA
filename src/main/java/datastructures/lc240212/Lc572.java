package datastructures.lc240212;

public class Lc572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;
        if(subRoot==null)
            return true;

        if(sameTree(root,subRoot))
            return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    boolean sameTree(TreeNode s,TreeNode t){
        if(s==null && t==null)
            return true;
        if(s!=null && t!=null && s.val==t.val){
            boolean left = sameTree(s.left,t.left);
            boolean right = sameTree(s.right,t.right);
            return left && right;
        }
        // 剩下其一為null / 都有值但不同值
        return false;
    }
}
