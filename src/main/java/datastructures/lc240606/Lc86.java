package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc86 {
    public ListNode partition(ListNode head, int x) {

        ListNode curr = head;
        ListNode d1 = new ListNode(0);
        ListNode left = d1;
        ListNode d2 = new ListNode(0);
        ListNode right = d2;
        while (curr!=null){
            int val = curr.val;
            if(val>=x){
                right.next = curr;
                right = right.next;
            }else {
                left.next = curr;
                left = left.next;
            }
            curr = curr.next;
        }
        left.next = null;
        right.next = null;

        left.next = d2.next;
        return d1.next;
    }
}
