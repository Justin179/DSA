package datastructures.lc240212;

import java.util.ArrayList;
import java.util.List;

public class Lc270 {
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;

        closestValue(n4,3.714286);
    }
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    public static int closestValue(TreeNode root, double target) {
        dfs(root,target);
        for(int i = 0; i<list.size(); i++){
            int curr = list.get(i);
            if(target>curr){
                if(i==list.size()-1){
                    return curr;
                } else {
                    int next = list.get(i+1);
                    double a = Math.abs(target-curr);
                    double b = Math.abs(target-next);
                    if(a<b){
                        return curr;
                    }else{
                        return next;
                    }
                }
            }
        }
        return min;
    }
    public static void dfs(TreeNode root, double target){
        if(root==null){
            return;
        }
        dfs(root.left,target);
        list.add(root.val);
        dfs(root.right,target);
    }

}
