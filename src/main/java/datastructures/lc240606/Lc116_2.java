package datastructures.lc240606;

import datastructures.common.Node;

public class Lc116_2 {
    public Node connect(Node root) {
        if(root==null)
            return null;
        if(root.left!=null){
            root.left.next = root.right;
        }
        if(root.right!=null && root.next!=null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
