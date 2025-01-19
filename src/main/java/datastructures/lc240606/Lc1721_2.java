package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc1721_2 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode l = head;
        ListNode r = head;
        for(int i = 1; i<k; i++){
            r = r.next;
        }
        ListNode p1 = r;

        while (r.next!=null){
            r = r.next;
            l = l.next;
        }

        int temp = p1.val;
        p1.val = l.val;;
        l.val = temp;

        return head;
    }
}
