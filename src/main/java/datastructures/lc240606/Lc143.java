package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        reorderList(head);
    }
    public static void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode curr1 = head;
        ListNode curr2 = reverseLinkedList(slow);
        merge(curr1,curr2);
        System.out.println(head);
    }

    private static void merge(ListNode curr1, ListNode curr2) {
        while (curr1!=null){
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr1.next = curr2;
            if(next1==null){
                break;
            }
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}

















