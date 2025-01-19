package datastructures.lc240606;

import java.util.Arrays;

public class Lc1011_2 {
    /*
        Input: weights = [1,2,3,4,5], ships = 2
        Output:
     */
    public int shipWithinDays(int[] weights, int ships)
    {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l<r){
            int shipCapacity = l+(r-l)/2;
            int shipNeeded = shipNeeded(weights,shipCapacity); // 10
            if(shipNeeded<=ships){ // 此capacity已足夠
                r = shipCapacity; // 尋求capacity再小的可能
            } else { // 此capacity不夠，capacity需要增加
                l = shipCapacity+1;
            }
        }
        return l;
    }

    private int shipNeeded(int[] weights, int shipCapacity) // 10
    {
        int accuWeight = 0;
        int ship = 1;
        for(int weight : weights){
            if(accuWeight+weight > shipCapacity){ // 如果這艘加下去會超重
                ship++; // 就要加船
                accuWeight = weight; // 累積重量reset
            } else { // 不超重
                accuWeight += weight; // 繼續累加
            }
        }
        return ship;
    }
}
