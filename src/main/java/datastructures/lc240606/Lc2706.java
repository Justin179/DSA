package datastructures.lc240606;

import java.util.Arrays;

public class Lc2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if(money-prices[0]-prices[1] >= 0)
            return money-prices[0]-prices[1];
        else
            return money;
    }
}
