package datastructures.lc240212;

import datastructures.common.ListNode;

public class Lc24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode i = head;
        ListNode j = head.next;
        head = j;
        while(i!=null && j!=null){
            ListNode k = j.next; // 存位置
            j.next = i;

            if(k!=null && k.next==null){
                i.next = k;
            } else {
                i.next = k!=null? k.next : null;
            }

            // 下一輪
            i = k;
            j = k!=null? k.next : null;
        }

        return head;
    }
}
