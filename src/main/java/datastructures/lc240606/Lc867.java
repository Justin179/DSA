package datastructures.lc240606;

public class Lc867 {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[cols][rows];
        for (int i = 0; i< matrix.length; i++){
            for (int j = 0; j<matrix[0].length; j++){
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
