package datastructures.lc240212;

public class Lc441 {
    public static void main(String[] args) {
        int result = arrangeCoins(5);
        System.out.println(result);
    }
    public static int arrangeCoins(int n) { // 5
        int remain = n;
        int curr = 1;
        while (true){
            remain = remain-curr;
            curr++;
            if(curr>remain){
                break;
            }
        }
        return curr-1;
    }
}
