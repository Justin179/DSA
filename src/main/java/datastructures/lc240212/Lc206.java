package datastructures.lc240212;

import datastructures.common.ListNode;

public class Lc206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode pre = head;
        ListNode i = head.next;
        while(i!=null){
            ListNode j = i.next; // 存下一個的位置
            i.next = pre; // 回指
            pre = i; // one step forward
            i = j; // one step forward
        }
        head.next = null;
        return pre;
    }


}
