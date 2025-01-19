package datastructures.lc240606;

public class Lc2483 {

    public int bestClosingTime(String customers) { // NYNYY
        char[] chars = customers.toCharArray();
        int length = customers.length();
        int[] prefix_n = new int[length + 1];
        prefix_n[0] = 0;
        int[] postfix_y = new int[length + 1];
        postfix_y[length] = 0;

        for(int i = 0; i<length; i++){ // 0 1 2 3 4
            prefix_n[i+1] = (chars[i]=='N'? 1 : 0) + prefix_n[i];
        }

        for(int i = length-1; i>=0; i--){
            postfix_y[i] = (chars[i]=='Y'? 1: 0) + postfix_y[i+1];
        }

        int[] sumArray  = new int[length + 1];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<=length; i++){
            int sum = prefix_n[i]+postfix_y[i];
            sumArray[i] = sum;
            min = Math.min(min,sum);
        }

        for(int i = 0; i<=length; i++){
            if(sumArray[i] == min){
                return i;
            }
        }

        return 0;
    }
}
