package datastructures.lc240330;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Lc752_2 {
    public int openLock(String[] deadends, String target) {
        Map<Character, Character> nextSlot = Map.of('0', '1', '1', '2', '2', '3', '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0'
        );
        Map<Character, Character> prevSlot = Map.of(
                '0', '9',
                '1', '0',
                '2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8'
        );

        // Set to store visited and dead-end combinations.
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();

        int turns = 0;

        if (visited.contains("0000")) {
            return -1;
        }

        // initial state
        queue.add("0000");
        // initial state visited
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(target)) {
                    return turns;
                }

                for (int wheel = 0; wheel < 4; wheel += 1) {
                    StringBuilder newCombination = new StringBuilder(curr);
                    newCombination.setCharAt(wheel, nextSlot.get(newCombination.charAt(wheel)));
                    if (!visited.contains(newCombination.toString())) {
                        queue.add(newCombination.toString());
                        visited.add(newCombination.toString());
                    }

                    newCombination = new StringBuilder(curr);
                    newCombination.setCharAt(wheel, prevSlot.get(newCombination.charAt(wheel)));
                    if (!visited.contains(newCombination.toString())) {
                        queue.add(newCombination.toString());
                        visited.add(newCombination.toString());
                    }
                }
            }
            turns += 1;
        }
        return -1;
    }
}