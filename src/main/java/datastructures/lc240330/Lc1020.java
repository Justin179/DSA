package datastructures.lc240330;

/*
The basic idea is to iterate through the boundary
If we encounter any island i.e. 1 then we will run DFS
And update all those islands as 2

Then check for the number of 1s remaining in the board
Since those are the ones that have not been visited and return
*/

public class Lc1020 {
    /*
        m   m   m
    n
    n
    n
     */
    public int numEnclaves(int[][] board) {
        int n = board.length; // 4 rows
        int m = board[0].length; // 4 cols

        // 只對perimeter為陸地的dfs
        for (int i = 0; i < n; i++) { // 0 1 2 3
            if (board[i][0] == 1) // 左邊陸地
                dfs(i, 0, board);
            if (board[i][m - 1] == 1) // 右邊陸地
                dfs(i, m - 1, board);
        }

        for (int i = 1; i < m - 1; i++) { // 1 2
            if (board[0][i] == 1) // 上面陸地
                dfs(0, i, board);
            if (board[n - 1][i] == 1) // 下面陸地
                dfs(n - 1, i, board);
        }

        return count(board);
    }

    // 走過即蓋上2
    public void dfs(int r, int c, int[][] board) { // row col board
        // 出界、走過的2、海0，就直接return
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 1)
            return;

        // 這一格走下去(mark as 2)
        board[r][c] = 2; // 走過的以2

        // 上下左右走
        dfs(r + 1, c, board);
        dfs(r - 1, c, board);
        dfs(r, c + 1, board);
        dfs(r, c - 1, board);
    }

    // 單純數幾個1
    public int count(int[][] board) {
        int c = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    c++;
                }
            }
        }
        return c;
    }

}

