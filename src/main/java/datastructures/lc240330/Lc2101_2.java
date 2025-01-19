package datastructures.lc240330;

import java.util.LinkedList;
import java.util.Queue;

public class Lc2101_2 {
    // The main idea here is to take each bomb and check the number of bombs in its range.
    public int maximumDetonation(int[][] bombs) { //
        int max = 0;
        for (int i = 0; i < bombs.length; i++) { // 0 1
            max = Math.max(max, getMaxDFS(i, bombs, new boolean[bombs.length]));
        }
        return max;
    }
    // 1, [[2,1,3],[6,1,4]], [false,false]
    private int getMaxDFS(int index, int[][] bombs, boolean[] seen) {
        int count = 1; // 必可自爆
        seen[index] = true; // [false,true]

        for (int i = 0; i < bombs.length; i++) { // i = 0 1
            if (!seen[i] && isInRange(bombs[index], bombs[i])) { // true && 1,0
                count += getMaxDFS(i, bombs, seen); // 0, bombs, [false,true]
            }
        }

        return count;
    }

    private boolean isInRange(int[] point1, int[] point2) {
        long dx = point1[0] - point2[0], dy = point1[1] - point2[1], radius = point1[2];
        long distance = dx * dx + dy * dy;
        return distance <= radius * radius;
    }
}