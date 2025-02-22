package datastructures.lc240330;

public class Lc200 {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        numIslands(grid);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, int i, int j){
        if(i<0||i>=grid.length||j<0||j>=grid[i].length||(grid[i][j]==0 || grid[i][j]=='0')){
            return;
        }
        grid[i][j] = 0;
        bfs(grid,i+1,j); // 上
        bfs(grid,i-1,j); // 下
        bfs(grid,i,j+1); // 左
        bfs(grid,i,j-1); // 右
    }
}
