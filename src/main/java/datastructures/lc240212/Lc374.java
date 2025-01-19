package datastructures.lc240212;

public class Lc374 {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(true){
            int mid = low+(high-low)/2;
            int result = guess(mid);
            if(result==1){
                low = mid+1;
            } else if (result==-1) {
                high = mid-1;
            } else {
                return mid;
            }
        }
    }

    private int guess(int mid) {
        return 0;
    }
}
