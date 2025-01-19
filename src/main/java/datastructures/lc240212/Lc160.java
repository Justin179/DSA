package datastructures.lc240212;

import datastructures.common.ListNode;

public class Lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a!=b){
            if (a==null){
                a = headB;
            } else {
                a = a.next;
            }
            if (b==null){
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}
