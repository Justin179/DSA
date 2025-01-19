package datastructures.lc240212;

import datastructures.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Lc234_2 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int l = 0;
        int r = list.size()-1;
        while (l<=r){
            if(list.get(l).intValue() != list.get(r).intValue()){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
