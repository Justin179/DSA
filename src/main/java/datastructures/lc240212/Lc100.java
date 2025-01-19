package datastructures.lc240212;


import java.util.ArrayList;
import java.util.List;

public class Lc100 {
    public static void main(String[] args) {
 /*
        The following code builds a tree that looks like:
            0
          /   \
         1     2
        */
//        TreeNode p = new TreeNode(0);
//        TreeNode pOne = new TreeNode(1);
//        TreeNode pTwo = new TreeNode(2);
//        p.left = pOne;
//        p.right = pTwo;

        TreeNode p = new TreeNode(1);
        TreeNode pOne = new TreeNode(2);
        p.left = pOne;

        TreeNode q = new TreeNode(1);
        TreeNode qOne = new TreeNode(2);
        q.right = qOne;

        isSameTree(p,q);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(p,list1);
        dfs(q,list2);


        if(list1.size()!=list2.size()){
            return false;
        }else{
            for(int i = 0; i<list1.size(); i++){
                if(list1.get(i)!=list2.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void dfs(TreeNode root, List<Integer> list){
        if(root==null){
            list.add(null);
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
