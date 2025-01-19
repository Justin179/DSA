package datastructures.lc240212;

import datastructures.common.ListNode;

public class ReverseLinkedList2 {

    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;

        ListNode result = reverseBetween(listNode1,1,2);
        System.out.println(result);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right){
            return head;
        }

        ListNode i = head;
        for(int c = 1; c<left; c++){ // left = 2
            i = i.next;
        }

        ListNode j = head;
        for(int c = 1; c<right; c++){ //
            j= j.next;
        }

        ListNode k = j.next;
        j.next = null;

        ListNode midAfter = reverse(i,k);

        int counter = 1;
        if(counter==left){
            return midAfter;
        }

        ListNode a = head;
        while(a!=null){
            if( (counter+1)==left ){
                a.next = midAfter;
                break;
            }
            counter++;
            a = a.next;
        }

        return head;
    }

    private static ListNode reverse(ListNode head, ListNode R){
        ListNode i = head;
        ListNode j = head.next;
        while(i!=null && j!=null){
            ListNode k = j.next;
            j.next = i;
            i = j;
            j = k;
        }
        head.next = R;
        return i;
    }

}
