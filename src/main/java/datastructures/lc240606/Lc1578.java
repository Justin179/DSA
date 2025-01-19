package datastructures.lc240606;

public class Lc1578 {
    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = new int[]{1,2,3,4,5};
        int res = minCost(colors, neededTime);
    }
    public static int minCost(String colors, int[] neededTime) {
        int res = 0;
        char[] chars = colors.toCharArray();
        for(int L = 0, R = 1; R<chars.length; R++){
            char l = chars[L];
            char r = chars[R];
            if(l!=r){
                L = R;
            } else { // l==r
                if(neededTime[L] <= neededTime[R]){ // 左邊小
                    res += neededTime[L];
                    L++;
                } else { // 右邊小
                    res += neededTime[R];
                }
            }
        }

        return res;
    }
}
