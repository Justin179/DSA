package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) { // 3 4
        ListNode curr = list1;
        int i = 1;
        while (i<a){ // 1 2
            curr = curr.next;
            i++;
        }
        // 此時的i=3
        ListNode head = curr;
        while (i<=(b+1)){ // 3 4 5
            curr = curr.next;
            i++;
        }

        ListNode curr2 = list2;
        while (curr2.next!=null){
            curr2 = curr2.next;
        }

        head.next = list2;
        curr2.next = curr;
        return list1;
    }
}
