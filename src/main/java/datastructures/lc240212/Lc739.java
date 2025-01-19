package datastructures.lc240212;

public class Lc739 {
    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(temperatures);
        System.out.println(ans);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i<(n-1); i++){
            int currI = temperatures[i];
            for(int j = i+1; j<n; j++){
                int currJ = temperatures[j];
                if(currJ>currI){
                    ans[i] = j-i;
                    break;
                }
            }
        }
        return ans;
    }
}
