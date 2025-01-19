package datastructures.lc240606;

public class ChampagneTower {
    public static void main(String[] args) {
        ChampagneTower tower = new ChampagneTower();
        System.out.println(tower.champagneTower(100, 4, 2)); // 測試用例
    }

    public double champagneTower(int poured, int queryRow, int queryGlass) { // 4
        double[] prevRow = new double[1];
        prevRow[0] = poured;

        for (int row = 1; row <= queryRow; row++) {
            double[] curRow = new double[row + 1];
            for (int i = 0; i < row; i++) {
                double extra = prevRow[i] - 1;
                if (extra > 0) {
                    curRow[i] += 0.5 * extra;
                    curRow[i + 1] += 0.5 * extra;
                }
            }
            prevRow = curRow;
        }

        return Math.min(1, prevRow[queryGlass]);
    }


}

