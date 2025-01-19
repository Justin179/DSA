package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc143_2 {
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
        ListNode s = head;
        ListNode f = head;
        ListNode p = null;
        while (f!=null&&f.next!=null){
            p = s;
            s = s.next;
            f = f.next.next;
        }
        p.next = null;

        ListNode list1 = head;
        ListNode list2 = reverse(s);

        merge(list1,list2);
    }

    private static void merge(ListNode l1, ListNode l2) {
        while (l1!=null && l2!=null){
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if(n1==null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    private static ListNode reverse(ListNode head) {
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

















