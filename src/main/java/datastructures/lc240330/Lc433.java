package datastructures.lc240330;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Lc433 {
    /*
     BFS
     We can imagine the problem as a graph.
     Each gene string is a node, and mutations are the edges.
     Two nodes have an edge (are neighbors) if they differ by one character.
     The added constraints are that the characters must be one of "ACGT", and each node must be in bank.

     Then, the problem is simplified: what is the shortest path between start and end?
     When a graph problem involves finding a shortest path, BFS should be used over DFS.
     This is because with BFS, all nodes at distance x from start will be visited before any node at distance x + 1 will be visited.
     Once we find the target (end), we know that we found it in the shortest number of steps possible.

     return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
     */
    public int minMutation(String start, String end, String[] bank) {

        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(start); // 球放進queue
        seen.add(start); // 球視同看過

        int steps = 0;

        while (!queue.isEmpty()) {
            int nodesInQueue = queue.size();
            for (int j = 0; j < nodesInQueue; j++) {
                String node = queue.remove(); // 同層的那些
                if (node.equals(end)) {
                    return steps;
                }

                for (char c: new char[] {'A', 'C', 'G', 'T'}) { // A C G T
                    for (int i = 0; i < node.length(); i++) { // AACCGGTT
                        String neighbor = node.substring(0, i) + c + node.substring(i + 1);
                        // 沒看過 且 在允許清單
                        if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            queue.add(neighbor); // 球放進queue
                            seen.add(neighbor); // 球視同看過
                        }
                    }
                }
            }

            steps++; // 每層加一
        }

        return -1;
    }
}