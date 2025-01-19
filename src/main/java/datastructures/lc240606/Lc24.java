package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            ListNode sec = cur.next;
            ListNode nex = cur.next.next;
            sec.next = cur;
            cur.next = nex;
            pre.next = sec;
            pre = cur;
            cur = nex;
        }
        return dummy.next;
    }
}
