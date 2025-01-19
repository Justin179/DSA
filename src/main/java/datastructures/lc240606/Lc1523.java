package datastructures.lc240606;

public class Lc1523 {
    public int countOdds(int low, int high) {
        int length = high-low+1;
        if(length%2==0){
            return length/2;
        }else {
            int base = (length+1)/2;
            if(low%2==0&&high%2==0){
                return base-1;
            } else {
                return base;
            }
        }
        // 1 2 3 4 --> 2 = 4/2
        // 2 3 4 5 --> 2 = 4/2
        // 3 4 5 6 --> 2 = 4/2
        // 1 2 --> 1 = 2/2
        // 長度為偶數，直砍半

        // 1 2 3 --> 2
        // 2 3 4 --> 1
        // 3 4 5 --> 2

        // 1 2 3 4 5 --> 3
        // 2 3 4 5 6 --> 2
        // 3 4 5 6 7 --> 3
    }
}
