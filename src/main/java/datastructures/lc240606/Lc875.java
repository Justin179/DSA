package datastructures.lc240606;

import java.util.Arrays;

public class Lc875 {
    public static void main(String[] args) {
        int[] piles = new int[]{805306368,805306368,805306368};
        int h =                1000000000;
        minEatingSpeed(piles,h);
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt(); // 805306368
        // piles = [3,6,7,11], h = 8
        int l = 1;
        int r = max; // 11
        int res = Integer.MAX_VALUE;
        while (l<=r){
            int k = l + (r-l)/2; // 6
            double speed = k;
            long sum = 0;
            for(int p : piles){
                sum+= (long) Math.ceil(p/speed);
            }
            if(sum<=h){ // 試圖找更小的 banana per hour
                r = k-1;
                res = Math.min((int)speed,res);
            }else {
                l = k+1;
            }
        }
        return res;
    }
}
