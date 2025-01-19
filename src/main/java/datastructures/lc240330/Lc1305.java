package datastructures.lc240330;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc1305 {
    List<Integer> ls=new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return ls;
        }
        inorderTraversal(root1);
        inorderTraversal(root2);
        Collections.sort(ls);
        return ls;
    }
    public void inorderTraversal(TreeNode root){
        if(root==null){
            return ;
        }
        inorderTraversal(root.left);
        ls.add(root.val);
        inorderTraversal(root.right);
    }
}
