package datastructures.lc240212;

import datastructures.common.ListNode;

import java.util.Stack;

public class Lc234 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(2);
//        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;


        boolean result = isPalindrome(listNode1);
        System.out.println(result);
    }

    public static boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode j = head;
        while(j!=null){
            stack.push(j.val);
            j = j.next;
        }

        ListNode prev = head;
        ListNode i = head.next;
        while(i!=null){
            ListNode next = i.next; // save next position
            i.next = prev;
            prev = i;
            i = next;

        }
        head.next = null;
        while(prev!=null){
            if(stack.peek()==prev.val){
                stack.pop();
            }
            prev = prev.next;
        }
        if(stack.size()==0){
            return true;
        } else {
            return false;
        }
    }
}
