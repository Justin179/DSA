package datastructures.lc240212;

import datastructures.common.ListNode;

public class Lc1721 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;


        ListNode result = swapNodes(listNode1,2);
        System.out.println(result);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        int n = 0;
        while(cur!=null){
            n++;
            cur = cur.next;
        }

        ListNode[] nodesArray = new ListNode[n];
        n = 0;
        cur = head;
        while(cur!=null){
            nodesArray[n] = cur;
            n++;
            cur = cur.next;
        }

        if(n==2 && (k==1||k==2)){
            ListNode temp = head;
            head = head.next;
            head.next = temp;
            temp.next = null;
            return head;
        }


        swapArrayNodes(nodesArray, k, n);




        cur = head;
        for(int i = 0; i<n ; i++){ // 01234
            int curVal = nodesArray[i].val;
            System.out.println(curVal);
            cur.val = curVal;
            cur = cur.next;
        }



        return head;
    }

    private static void swapArrayNodes(ListNode[] nodesArray, int k, int n) {
        int left = k-1;
        int right = n-k;
        // save left
        ListNode temp = nodesArray[left];
        nodesArray[left] = nodesArray[right];
        nodesArray[right] = temp;
    }

}
