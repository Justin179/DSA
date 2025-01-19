package datastructures.lc240330;

import java.util.LinkedList;
import java.util.Queue;

public class Lc1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int columns = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        int steps = 0;
        int x, y;
        while (!queue.isEmpty()) {
            steps++; // 1

            int n = queue.size();
            for (int i = 0; i < n; i++) { // 可走的
                int[] current = queue.poll();

                for (int[] direction : directions) { // 上下左右
                    // x y 下一步
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    // 下一步若是界外 不走
                    if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                    // 下一步若是牆 不走
                    if (maze[x][y] == '+') continue;

                    // 觸邊了
                    if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) return steps;

                    maze[x][y] = '+'; // 這是避免走回頭路
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
