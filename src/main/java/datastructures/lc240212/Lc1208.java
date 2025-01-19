package datastructures.lc240212;

public class Lc1208 {
    public static void main(String[] args) {
        String s = "krrgw";
        String t = "zjxss";
        int maxCost = 19;
        int result = equalSubString(s,t,maxCost);
        System.out.println(result);
    }

    public static int equalSubString(String s, String t, int maxCost) {
        // https://www.youtube.com/watch?v=Renmq5-dxfw  看懂題
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int currentCost = 0;
        int maxLength = 0;
        for(int i = 0; i<charArrayS.length; i++){ // 0 1 2 3
            currentCost += Math.abs(charArrayS[i] - charArrayT[i]);
            if(currentCost > maxCost){
                maxLength = i;
                break;
            }
        }
        return maxLength;
    }
}
