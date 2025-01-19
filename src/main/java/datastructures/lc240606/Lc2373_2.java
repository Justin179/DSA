package datastructures.lc240606;

public class Lc2373_2 {
    public int[][] largestLocal(int[][] grid) {
        int row = grid.length; // 5
        int col = grid[0].length; // 5
        int[][] res = new int[row-2][col-2];
        for(int i = 0; i<row-2; i++){ // 0 1 2
            for(int j = 0; j<col-2; j++){ // 0 1 2
                int max = findMax(i,j,grid);
                res[i][j] = max;
            }
        }
        return res;
    }

    private int findMax(int x, int y, int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i = x; i<x+3; i++){
            for(int j = y; j<y+3; j++){
                max = Math.max(max,grid[i][j]);
            }
        }
        return max;
    }


}
