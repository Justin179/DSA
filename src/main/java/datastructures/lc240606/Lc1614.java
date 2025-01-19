package datastructures.lc240606;

public class Lc1614 {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int max = 0;
        for (char c : chars){
            if(c=='(')
                count++;
            if (c==')')
                count--;
            max = Math.max(max,count);
        }
        return max;
    }
}
