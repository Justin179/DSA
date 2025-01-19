package datastructures.lc240606;

import datastructures.common.Node;

import java.util.HashMap;
import java.util.Map;

public class Lc138 {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node curr = head;
        while (curr!=null){
            Node currCopy = new Node(curr.val);
            map.put(curr,currCopy);
            curr = curr.next;
        }
        curr = head;
        while (curr!=null){
            Node currCopy = map.get(curr);
            currCopy.next = map.get(curr.next);
            currCopy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
