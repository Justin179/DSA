package datastructures.lc240212;

public class Lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null)
            return null;
        return constructBST(nums,0,nums.length-1);
    }
    TreeNode constructBST(int[] nums, int left, int right){
        if(left>right)
            return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums,left,mid-1);
        root.right = constructBST(nums,mid+1,right);
        return root;
    }
}
