package datastructures.lc240606;


import datastructures.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc2487 {

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(13);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        removeNodes(a);
    }

    public static ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr!=null){
            while (!stack.isEmpty() && stack.peek().intValue()< curr.val){
                stack.pop();
            }
            stack.push(curr.val);
            curr = curr.next;
        }

//        List<Integer> list = new ArrayList<>();
        ListNode pre = null;
        while (!stack.isEmpty()){
            ListNode currNode = new ListNode(stack.pop());
            currNode.next = pre;
            pre = currNode;
        }

        return pre;
    }
}
