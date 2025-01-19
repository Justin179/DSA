package datastructures.lc240606;

public class Lc9 {
    public boolean isPalindrome(int x) {
        char[] chars = (x+"").toCharArray();

        int length = chars.length;
        int j = 0;
        for(int i = length-1; i>=0; i--){
            char backward = chars[i];
            char forward = chars[j++];
            if(backward!=forward)
                return false;
        }

        return true;
    }
}
