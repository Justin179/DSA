package datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;

public class BT_List {

    public static void main(String[] args) {
        Integer[] nums = {5
        ,2,6
        ,1,4,null,7
        ,null,null,3,null,null,null
        ,null,null};
        BT_List bt = new BT_List(nums);
        bt.buildtree();
        System.out.println(bt.root);

    }

    private Integer[] nums;
    private Node root;

    public static class Node {
        public Node left;
        public Node right;
        public int val;

        public Node(){}
        public Node(int val) {
            this.val = val;
        }
    }

    public BT_List(Integer[] nums) {
        this.nums = nums;
    }

    // 非本章學習重點(本方法僅模擬測試資料用）
    public void buildtree () {
        if (this.nums.length < 0) return;
        if (this.nums[0] == null) return;

        // prepare Node instances
        Node[] nodes_tmp = new Node[this.nums.length];
        for (int i = 0; i < this.nums.length; i++) {
            if (this.nums[i] == null) continue;
            nodes_tmp[i] = new Node(this.nums[i]);
        }
        // set root
        this.root = nodes_tmp[0];

        for (int i = 0; i < this.nums.length; i++) {
            int i_left = (i + 1) * 2 - 1; // i_left_plus_one = (i_node_plus_one) * 2 -> i_left = i_left_plus_one - 1
            int i_right = (i + 1) * 2 + 1 - 1; // i_right_plus_one = (i_node_plus_one) * 2 + 1-> i_right = i_right_plus_one - 1

            Node node = nodes_tmp[i];
            if (node == null) continue;

            if (i_left < this.nums.length) {
                node.left = nodes_tmp[i_left];
            }
            if (i_right < this.nums.length) {
                node.right = nodes_tmp[i_right];
            }
        }
    }

    /** level-order traversal (BFS): lv1 -> lv2 -> lv3 **/
    public void traverse_levelorder_bfs() {
        if (this.root == null) return;

        Queue<Node> q = new LinkedList<Node>();
        /** initialization **/
        q.add(this.root);
        while (true) {
            /** end condition **/
            if (q.size() == 0) break; // empty queue
            Node node = q.poll();
            if (node == null) continue; // out of bound index

            /** main logic **/
            System.out.print(node.val + " ");

            /** data flow **/
            q.add(node.left);
            q.add(node.right);
        }
    }


}




