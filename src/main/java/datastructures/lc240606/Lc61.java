package datastructures.lc240606;

import datastructures.common.ListNode;


public class Lc61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;

        int count = 0;
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            count++;
        }
        k = k%count;
        if(k==0)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        int i = 1;
        while (i<=(count-k)){
            curr = curr.next;
            pre = pre.next;
            i++;
        }
        pre.next = null;

        ListNode tail = curr;
        while (tail.next!=null){
            tail = tail.next;
        }
        tail.next = head;

        return curr;
    }
}



















