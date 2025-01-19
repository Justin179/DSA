package datastructures.lc240606;

public class Lc191 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            count += n&1;
            n = n >>> 1;
        }
        return count;
    }
}
