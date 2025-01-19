package datastructures.lc240606;

import datastructures.common.ListNode;

public class Lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1!=null || l2!=null){
            int a = l1!=null? l1.val : 0;
            int b = l2!=null? l2.val : 0;
            int sum = a+b+carry;
            carry = sum/10;
            int currNum = sum%10;
            curr.next = new ListNode(currNum);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if(carry==1){
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
