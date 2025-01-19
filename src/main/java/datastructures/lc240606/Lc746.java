package datastructures.lc240606;

public class Lc746 {
    public static void main(String[] args) {
        int[] cost = new int[]{10,15,20};
        minCostClimbingStairs(cost);
    }
    public static int minCostClimbingStairs(int[] cost) {

        for(int i = 2; i<cost.length; i++){
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }
}
