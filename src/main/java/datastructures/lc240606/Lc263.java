package datastructures.lc240606;

public class Lc263 {
    public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        // 2 3 5
        int[] ints = new int[]{2,3,5};
        for (int i : ints){
            while (n%i==0){
                n = n/i;
            }
        }
        return n==1;
    }
}
