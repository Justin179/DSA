package datastructures.lc240606;

import java.util.LinkedList;
import java.util.List;

public class Lc989 {
    public static void main(String[] args) {
        int[] num = new int[]{9,9,9,9,9,9,9,9,9,9};
        addToArrayForm(num,1);
    }
    public static List<Integer> addToArrayForm(int[] num, int K) { // 274  181
        List<Integer> res = new LinkedList<>();
        for (int i = num.length - 1; i >= 0; --i) { // 4 7 2
            res.add(0, (num[i] + K) % 10); // 185 25 4 (5 5 4)
            K = (num[i] + K) / 10; // 18 2 0
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}
