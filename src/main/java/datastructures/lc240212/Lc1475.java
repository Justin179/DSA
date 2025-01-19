package datastructures.lc240212;

import java.util.Arrays;

public class Lc1475 {
    public static void main(String[] args) {
        int[] prices = new int[]{8,4,6,2,3};
        int[] ints = finalPrices(prices);
        System.out.println(ints);
    }

    public static int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        Arrays.fill(ans,-1);
        for(int i = 0; i<prices.length-1; i++){
            int iPrice = prices[i];
            for(int j = i+1; j<prices.length; j++){
                int jPrice = prices[j];
                if(jPrice <= iPrice){
                    ans[i] = iPrice-jPrice;
                    break;
                }
            }
            if(ans[i]==-1){
                ans[i] = iPrice;
            }
        }
        int n = prices.length;
        ans[n-1] = prices[n-1];
        return ans;
    }
}
