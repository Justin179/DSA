package datastructures.lc240606;

public class Lc661 {
    public static void main(String[] args) {
        int[][] img = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        imageSmoother(img);
    }
    public static int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                int count = 0;
                int sum = 0;
                for(int x = i-1; x<=i+1; x++){
                    for(int y = j-1; y<=j+1; y++){
                        if(x<0 || y<0 || x>=rows || y>=cols){
                            continue;
                        }
                        sum+=img[x][y];
                        count++;
                    }
                }
                result[i][j] = sum/count;
            }
        }
        return result;
    }
}
