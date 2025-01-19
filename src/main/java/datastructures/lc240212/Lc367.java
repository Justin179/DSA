package datastructures.lc240212;

public class Lc367 {
    public boolean isPerfectSquare(int num) { // 16
        long l = 1;
        long r = num;
        while (l<=r){
            long mid = l + (r-l)/2;
            long curr = mid*mid;
            if(curr==num){
                return true;
            } else if (curr>num) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return false;
    }
}
