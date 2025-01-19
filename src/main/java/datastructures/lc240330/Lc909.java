package datastructures.lc240330;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Lc909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length; // 6

        Map<Integer, Integer> hm = new HashMap<>();
        //as we are starting from 1st position so we are adding 1 and the number of steps taken are 0
        hm.put(1, 0); // position 1, steps 0

        Queue<Integer> q = new LinkedList<>();
        q.add(1); // for starting bfs
        while (!q.isEmpty()) {
            int p = q.poll(); // 1
            if (p == n * n) return hm.get(p); // return pos 36's steps

            for (int i = p + 1; i <= Math.min(p + 6, n * n); i++) {
                int next = check(i, n);//getting the next most suitable position to jump
                int row = next / n, col = next % n;
                int ns = board[row][col] == -1 ? i : board[row][col];
                /*normal BFS*/
                if (!hm.containsKey(ns)) {
                    hm.put(ns, hm.get(p) + 1);
                    q.offer(ns);
                }
            }
        }
        return -1;
    }

    public static int check(int i, int n) {
        int q = (i - 1) / n, r = (i - 1) % n;
        int row = n - 1 - q;
        int col = row % 2 != n % 2 ? r : n - 1 - r;
        return row * n + col;
    }
}
