package datastructures.lc240606;

public class Lc231 {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}
