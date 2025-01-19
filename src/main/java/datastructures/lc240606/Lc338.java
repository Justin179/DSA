package datastructures.lc240606;

public class Lc338 {
    public static void main(String[] args) {
        int[] ints = countBits(5);
        System.out.println(ints);
    }
    public static int[] countBits(int n) { // 5
        int[] result = new int[n+1];
        for(int i = 0; i<=n; i++){
            int count = 0;
            int curr = i;
            while (curr!=0){ // 012345
                if(curr%2==1)
                    count++;
                curr/=2;// 2 1 0
            }
            result[i] = count;
        }
        return result;
    }
}
