package datastructures.lc240606;

import java.util.HashSet;
import java.util.Set;

public class Lc202 {
    public static void main(String[] args) {
        boolean happy = isHappy(7);
        System.out.println(happy);
    }

    static Set<Integer> set = new HashSet<>();
    public static boolean isHappy(int n) {
        if(n==1)
            return true;

        char[] chars = (n + "").toCharArray();
        int sum = 0;
        for(char c : chars){
            int curr = c-'0';
            sum+= curr*curr;
        }
        if(set.contains(sum))
            return false;
        else
            set.add(sum);

        return isHappy(sum);
    }
}
