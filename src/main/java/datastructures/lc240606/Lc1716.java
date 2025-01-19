package datastructures.lc240606;

public class Lc1716 {
    public static void main(String[] args) {
        totalMoney(26);
    }
    public static int totalMoney(int n) {
        // 28
        // 35
        // 42
        // * * *
        if(n/7 == 0){
            int sum = 0;
            for(int i = 1; i<=n; i++){
                sum+=i;
            }
            return sum;
        } else {
            int rows = n/7; // 3
            int baseSum = 0;
            for(int i = 0; i<rows; i++){ // 0 1 2
                baseSum += 28 + i*7;
            }

            int starting = rows+1; // 2
            int lastSum = 0; // 9
            for(int i = starting; i<(starting + n%7); i++){
                lastSum+=i;
            }
            return baseSum+lastSum;
        }



    }
}
