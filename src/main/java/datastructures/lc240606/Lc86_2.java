package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc86_2 {
    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(0);
        ListNode c1 = d1;
        ListNode d2 = new ListNode(0);
        ListNode c2 = d2;

        ListNode curr = head;
        while (curr!=null){
            int val = curr.val;
            if(val>=x){
                c2.next = curr;
                c2 = c2.next;
            }else {
                c1.next = curr;
                c1 = c1.next;
            }
            curr = curr.next;
        }
        c2.next = null;
        c1.next = d2.next;
        return  d1.next;
    }
}
