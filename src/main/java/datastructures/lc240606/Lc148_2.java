package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc148_2 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        // 切半
        ListNode l = head;
        ListNode r = head.next;
        while (r!=null&&r.next!=null){
            l = l.next;
            r = r.next.next;
        }
        ListNode head2 = l.next;
        l.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(head2);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left!=null&&right!=null){
            if(left.val < right.val){
                curr.next = left;
                left = left.next;
            }else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left!=null? left : right;
        return dummy.next;
    }


}
