package datastructures.lc240330;

import java.util.ArrayList;
import java.util.List;

public class Lc872 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(200);
        root1.left = left1;
        root1.right = right1;

        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(200);
        root2.left = left2;
        root2.right = right2;

        leafSimilar(root1,root2);
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        if(list1.size()!=list2.size()){
            return false;
        }
        for(int i = 0; i<list1.size(); i++){
            if(list1.get(i)!=list2.get(i)){
                return false;
            }
        }
        return true;
    }

    static void dfs(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            list.add(root.val);
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
