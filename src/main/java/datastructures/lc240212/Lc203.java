package datastructures.lc240212;

import datastructures.common.ListNode;

public class Lc203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null && head.val==val){
            head = head.next;
        }
        ListNode curr = head;
        while (curr!=null && curr.next!=null){
            if(curr.next.val==val){ // curr不動
                curr.next = curr.next.next;
            } else { // curr動
                curr = curr.next;
            }
        }
        return head;
    }
}
