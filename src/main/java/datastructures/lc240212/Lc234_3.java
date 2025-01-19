package datastructures.lc240212;

import datastructures.common.ListNode;

public class Lc234_3 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){ // 因為fast一次走兩步，滿足這條件才可能走上兩步
            fast = fast.next.next; // 滿足上面的條件，這裡才不會出事
            slow = slow.next;
        }

        ListNode prev = null;
        while (slow!=null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        while (head!=null && prev!=null){
            if(head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
