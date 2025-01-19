package datastructures.lc240212;

import datastructures.common.ListNode;

public class Lc21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1!=null && list2!=null){
            int v1 = list1.val;
            int v2 = list2.val;
            if(v1<v2){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1!=null){
            curr.next = list1;
        }
        if (list2!=null){
            curr.next = list2;
        }
        return dummy.next;
    }
}
