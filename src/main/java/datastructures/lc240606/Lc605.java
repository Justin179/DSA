package datastructures.lc240606;

public class Lc605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length; // 5
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < size; i++) { // 0 1 2 3 4
            // 可以種的條件(三空)
            // curr為空 且 curr指向第一個or curr的左空 且
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == size - 1 || flowerbed[i + 1] == 0)) {
                n--;
                if (n == 0) {
                    return true;
                }
                flowerbed[i] = 1;
            }
        }

        return false;
    }
}

