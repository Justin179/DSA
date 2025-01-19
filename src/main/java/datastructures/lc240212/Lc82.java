package datastructures.lc240212;

import datastructures.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Lc82 {
    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(3);
//        ListNode listNode5 = new ListNode(4);
//        ListNode listNode6 = new ListNode(4);
//        ListNode listNode7 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode result = deleteDuplicates(listNode1);
        System.out.println(result);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        ListNode i = head;
        while(i!=null){
            if(set1.contains(i.val)){
                duplicates.add(i.val);
            }else{
                set1.add(i.val);
            }
            i = i.next;
        }

        i = head;
        while(i!=null){

            while(i.next!=null && duplicates.contains(i.next.val)){
                i.next = i.next.next;
            }

            i = i.next;
        }

        if(duplicates.contains(head.val)){
            head = head.next;
        }

        return head;
    }
}
