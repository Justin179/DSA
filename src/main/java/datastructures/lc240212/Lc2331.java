package datastructures.lc240212;

public class Lc2331 {
    public boolean evaluateTree(TreeNode root) {
        if(root.left==null)
            return root.val==1;
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if(root.val==2){
            return left || right;
        } else { // and
            return left && right;
        }
    }
}
