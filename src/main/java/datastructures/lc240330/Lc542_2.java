package datastructures.lc240330;

import java.util.LinkedList;
import java.util.Queue;


public class Lc542_2 {
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length; // 直3
        n = mat[0].length; // 橫3

        Queue<State> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];

        // 全掃過，把零加到queue裡，並記錄為已走過
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    queue.add(new State(row, col, 1));
                    seen[row][col] = true;
                }
            }
        }
        // 原本mat中是零的部分，因為不可能有人走，所以原本是零的地方就一直為零

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row;
            int col = state.col;
            int steps = state.steps;

            // 走4個方向
            for (int[] direction: directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                // 沒出界且為1 && 沒走過  才能走
                if (valid(nextRow, nextCol, mat) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                    mat[nextRow][nextCol] = steps;
                }
            }
        }

        return mat;
    }

    public boolean valid(int row, int col, int[][] mat) {
        return 0 <= row && row < m && 0 <= col && col < n && mat[row][col] == 1;
    }
}