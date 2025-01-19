package datastructures.lc240212;

public class Lc938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null) // base case
            return 0;
        if (root.val>high) // 太大只走左
            return rangeSumBST(root.left,low,high);
        if (root.val<low) // 太小只走右
            return rangeSumBST(root.right,low,high);
        // within range: 主行為 = 加總後回傳
        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}
