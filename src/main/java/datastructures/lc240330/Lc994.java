package datastructures.lc240330;

import java.util.LinkedList;
import java.util.Queue;

public class Lc994 {

    public int orangesRotting(int[][] grid) { // Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
        int m = grid.length; // rows
        int n = grid[0].length; // cols
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0; // 算出一開始有幾顆是好的

        // 算出一開始有幾顆是好的 + 把爛的座標存進queue
        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j}); // 爛的，就把其座標存進queue
                else if (grid[i][j] == 1)
                    fresh += 1;
            }
        }


        int count = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 上下左右
        while (!queue.isEmpty() && fresh != 0) { // queue還沒清空 且 還沒爛光 才繼續
            count += 1;
            int size = queue.size();
            for (int i = 0; i < size; i += 1) { // 掃一圈 (此輪爛掉的)
                int[] rotten = queue.poll(); // curr爛掉的

                int r = rotten[0];
                int c = rotten[1];
                for (int[] dir : dirs) { // 上下左右
                    int x = r + dir[0];
                    int y = c + dir[1];
                    // 界內且為好的才走
                    if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2; // 走過即爛
                        queue.offer(new int[]{x, y}); // 爛的放進queue
                        fresh -= 1; // 好的-1
                    }
                }
            } // end of for

        }

        return fresh == 0 ? count : -1; // 仍有好的就回-1
    }
}
