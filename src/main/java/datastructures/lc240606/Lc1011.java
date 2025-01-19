package datastructures.lc240606;

import java.util.Arrays;

public class Lc1011 {
    /*
        Input: weights = [1,2,3,4,5], ships = 2
        Output:
     */
    public int shipWithinDays(int[] weights, int ships)
    {
        int l = Arrays.stream(weights).max().getAsInt(); // 5
        int r = Arrays.stream(weights).sum(); // 15
        // 9
        while (l < r) {
            final int m = (l + r) / 2; // 7
            if (shipDays(weights, m) <= ships)
                r = m; // 10
            else
                l = m + 1; // 8
        }
        return l;
    }

    private int shipDays(int[] weights, int shipCapacity) // 10
    {
        int ships = 1;
        int capacity = 0;
        for (final int weight : weights) // 1 2 3 4 5
        {
            // 加此船，就會超重的話
            if (capacity + weight > shipCapacity)
            {
                ++ships; // 不夠了，加船
                capacity = weight;
            }
            else
                capacity += weight;
        }
        return ships;
    }
}
