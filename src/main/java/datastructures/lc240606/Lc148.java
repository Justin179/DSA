package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc148 {
    public ListNode sortList(ListNode head) {
        // base case
        if(head==null || head.next==null){
            return head;
        }

        // 切半
        ListNode left = head;
        ListNode right = head.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        ListNode head2 = left.next;
        left.next = null;


        ListNode l = sortList(head);
        ListNode r = sortList(head2);
        return merge(l,r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l!=null && r!=null){
            if(l.val<r.val){
                curr.next = l;
                l = l.next;
            } else {
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        curr.next = l!=null? l : r;
        return dummy.next;
    }
}
