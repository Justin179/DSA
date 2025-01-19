package datastructures.lc240330;

import java.util.PriorityQueue;

public class RecallPriorityQueue {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4,3,1,5,2};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer num : nums){
            priorityQueue.add(num);
        }
        while (!priorityQueue.isEmpty()){
            Integer poll = priorityQueue.poll();
            System.out.println(poll);
        }
    }

}
