package datastructures.lc240606;

public class Lc1903 {
    public String largestOddNumber(String num) {
        char[] chars = num.toCharArray();
        for (int i = chars.length-1; i>=0; i--){
            int currNum = chars[i] - '0';
            if(currNum%2 != 0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
