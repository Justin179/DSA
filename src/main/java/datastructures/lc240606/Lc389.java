package datastructures.lc240606;

public class Lc389 {
    public char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        int sum = 0;
        for (char c : chars){
            sum += (int) c;
        }
        int sum1 = 0;
        for(char c : chars1){
            sum1 += (int) c;
        }
        return (char) (sum1-sum);
    }
}
