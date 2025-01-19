package datastructures.lc240606;

public class Lc1137 {
    public int tribonacci(int n) {
        int[] arr = new int[]{0,1,1}; // 0 1 2
        if(n<3)
            return arr[n];

        // n = 4
        for(int i = 3; i<=n; i++){ // n=3執行1次; n=4執行兩次
            int sum = arr[0]+arr[1]+arr[2];
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = sum;
        }


        return arr[2];
    }
}
