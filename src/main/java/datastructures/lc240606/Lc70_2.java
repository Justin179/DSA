package datastructures.lc240606;

public class Lc70_2 {
    public static void main(String[] args) {
        climbStairs(5);
    }
    public static int climbStairs(int n) {
        int one = 1; // 左
        int two = 1; // 右
        for(int i = 0; i<n-1; i++){ // 0 1 2 3
            int temp = one;
            one = one+two;
            two = temp;
        }
        return one;
    }
}
