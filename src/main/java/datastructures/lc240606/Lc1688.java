package datastructures.lc240606;

public class Lc1688 {
    public int numberOfMatches(int n) {
        int countMatches = 0;
        while (n>1){
            countMatches+=n/2;
            n = (int)Math.ceil(n/2.0);
        }
        return countMatches;
    }
}
