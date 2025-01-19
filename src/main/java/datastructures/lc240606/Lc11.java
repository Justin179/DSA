package datastructures.lc240606;

public class Lc11 {
    public int maxArea(int[] height) {
        int max = 0;
        int L = 0;
        int R = height.length-1;
        while (L<R){
            if(height[L] < height[R]){
                max = Math.max(max, height[L]*(R-L));
                L++;
            } else {
                max = Math.max(max, height[R]*(R-L));
                R--;
            }
        }
        return max;
    }
}
