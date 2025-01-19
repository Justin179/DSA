package datastructures.lc240330;

import java.util.HashMap;
import java.util.Map;

public class Lc133 {
    public Node cloneGraph(Node node){
        if(node == null)
            return null;
        Map<Integer,Node> map = new HashMap<>();
        return cloneGraph(node,map);
    }

    // <Integer, Node copy>

    // make a copy node & return the copy
    private Node cloneGraph(Node node, Map<Integer,Node> map){
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }

        Node copy = new Node(node.val); // 1
        map.put(node.val,copy); // 1, 1 copy

        for(Node neighbor : node.neighbors){ // 2 4
            copy.neighbors.add(cloneGraph(neighbor,map)); // dfs
            // 已放的就直拿後return; 沒放的就new然後放
        }

        return copy;
    }


}
