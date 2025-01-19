package datastructures.lc240606;

import datastructures.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc2130 {
    public int pairSum(ListNode head) {
        ListNode curr = head;
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (curr!=null){
            list.add(curr.val);
            list2.add(curr.val);
            curr = curr.next;
        }
        Collections.reverse(list2);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<=list.size()/2; i++){
            int currSum = list.get(i) + list2.get(i);
            max = Math.max(max,currSum);
        }
        return max;
    }
}
