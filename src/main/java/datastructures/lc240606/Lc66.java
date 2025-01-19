package datastructures.lc240606;

public class Lc66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length-1; i>=0; i--){
            if(digits[i]<9){
                digits[i] +=1;
                return digits;
            }
            digits[i] = 0;
        }

        if(digits[0] == 0){
            int[] ints = new int[length+1];
            ints[0] = 1;
            return ints;
        }
        return digits;
    }
}
