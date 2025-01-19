package datastructures.lc240606;

public class Lc74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i<matrix.length; i++){
            int leng = matrix[i].length;
            if(target>=matrix[i][0] && target<=matrix[i][leng-1]){
                int l = 0;
                int r = leng-1;
                while (l<=r){
                    int m = l + (r-l)/2;
                    int curr = matrix[i][m];
                    if(target>curr){
                        l = m+1;
                    } else if (target<curr) {
                        r = m-1;
                    }else {
                        return true;
                    }
                }
            }else {
                continue;
            }
        }
        return false;
    }
}
