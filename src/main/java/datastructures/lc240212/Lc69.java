package datastructures.lc240212;

public class Lc69 {
    public static void main(String[] args) {
        mySqrt(8);
    }
    public static int mySqrt(int x) {
        long l = 0;
        long r = x;
        long res = 0;
        while (l<=r){
            long mid = l + (r-l)/2;
            long num = mid*mid;
            if(num>x){                r = mid-1;
            } else if (num<x) {
                l = mid+1;
                res = mid;
            } else {
                return (int)mid;
            }
        }
        return (int)res;
    }
}
