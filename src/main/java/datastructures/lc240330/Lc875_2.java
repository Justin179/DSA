package datastructures.lc240330;

import java.util.Arrays;

public class Lc875_2 {

    public static void main(String[] args) {
        int[] piles = new int[]{805306368,805306368,805306368};
        int h = 1000000000;
        int ans = minEatingSpeed(piles,h);
        System.out.println(ans);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        //二分法
        int right = Arrays.stream(piles).max().getAsInt();
        int left = 1;

        while (left<=right){
            int mid = left+(right-left)/2;

            if (canEatAll(piles,h,mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static boolean canEatAll(int [] piles,int h,int k){

        int hours = 0;
        for(int pile : piles){
//            int a = pile/k;
//            int b = pile%k !=0 ? 1 : 0;
//            hours += (a+b);
            hours+= pile%k!=0? pile/k +1 : pile/k;
            if(hours>h)
                return false;
        }
        return true;

//        int cnt = 0;
//        for(int pile : piles){
//            int currH = pile%k == 0 ? pile/k : pile/k+1;
//            cnt += currH;
//            if (cnt>h){
//                return false;
//            }
//        }
//        return true;
    }
}
