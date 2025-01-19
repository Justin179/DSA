package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = dummy;
        for(int i = 1; i<=n+1; i++){
            r = r.next;
        }
        while (r!=null){
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }
}
