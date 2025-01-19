package datastructures.lc240330;

public class Lc875 {

    public static void main(String[] args) {
        int[] piles = new int[]{805306368,805306368,805306368};
        int h = 1000000000;
        int ans = minEatingSpeed(piles,h);
        System.out.println(ans);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i : piles){
            max = Math.max(max,i);
        }

        int left = 1;
        int right = max;
        int min = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right - left)/2;
            System.out.println(mid);
            boolean withinTheLimit = withinTheLimit(piles, mid, h);
            if(withinTheLimit){
                min = Math.min(min,mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return min;
    }

    private static boolean withinTheLimit(int[] piles, int mid, int h) {
        int sum = 0;
        for(int pile : piles){
            int a = pile/mid;
            int b = pile%mid !=0 ? 1 : 0;
            sum += (a+b);
        }
        return sum<=h? true:false;
    }
}
