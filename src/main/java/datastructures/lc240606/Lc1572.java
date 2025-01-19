package datastructures.lc240606;

public class Lc1572 {
    public int diagonalSum(int[][] mat) {
        int primarySum = 0;
        int secondarySum = 0;
        int length = mat[0].length;
        for(int i=0; i<length; i++){
            primarySum+= mat[i][i];
            secondarySum+= mat[i][length-1-i];
        }
        if(length%2==0){
            return primarySum+secondarySum;
        }else {
            int mid = length/2;
            return primarySum+secondarySum-mat[mid][mid];
        }
    }
}
