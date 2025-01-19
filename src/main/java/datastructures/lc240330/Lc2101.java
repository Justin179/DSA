package datastructures.lc240330;

import java.util.LinkedList;
import java.util.Queue;

public class Lc2101 {
    // The main idea here is to take each bomb and check the number of bombs in its range.
    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        //iterate through each bomb and keep track of max
        for(int i = 0; i<bombs.length; i++){ // 0 1
            max = Math.max(max, getMaxBFS(bombs, i));
        }
        return max;
    }

    private int getMaxBFS(int[][] bombs, int index){ // index 0 1
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[bombs.length];

        seen[index] = true; // false,true
        queue.offer(index); // 1

        int count = 1; // start from 1 since the first added bomb can detonate itself

        while(!queue.isEmpty()){
            int currBomb = queue.poll(); // 1
            for(int j = 0; j<bombs.length; j++){ // 0 1  search for bombs to detonate
                if(!seen[j] && isInRange(bombs[currBomb], bombs[j])){ // 1 0
                    seen[j] = true; // true,true
                    count++; // 2
                    queue.offer(j); // 0
                }
            }
        }

        return count;
    }

    // use the distance between two points formula
    // then check if curr bomb radius is greater than the distance; meaning we can detonate the second bombs
    private boolean isInRange(int[] point1, int[] point2) { // [2,1,3],[6,1,4]
        long dx = point1[0] - point2[0]; // x dis
        long dy = point1[1] - point2[1]; // y dis
        long radius = point1[2]; // 爆炸範圍3
        long distance =  dx * dx + dy * dy; // 兩點的距離 (數學公式)
        return distance <= radius * radius; // 爆炸範圍>=radius
    }
}