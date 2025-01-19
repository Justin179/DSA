package datastructures.lc240330;

import java.util.LinkedList;
import java.util.Queue;

public class Lc1091 {
}



class Solution {
    int n;
    int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        // 第一個即不合法，直接回傳-1
        if (grid[0][0] == 1) {
            return -1;
        }

        n = grid.length;

        // more convenient to use a 2d array instead of a set for seen
        // 記錄已經走過的
        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1)); // row, col, steps

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row;
            int col = state.col;
            int steps = state.steps;
            if (row == n - 1 && col == n - 1) { // find target, return steps
                return steps;
            }

            for (int[] direction: directions) { // 走8個方向
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                // 範圍內且為零 且 沒走過
                if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                }
            }
        }

        return -1;
    }

    // 範圍內 且 為零 即合法
    public boolean valid(int row, int col, int[][] grid) {
        return 0 <= row && row < n && 0 <= col && col < n && grid[row][col] == 0;
    }
}
