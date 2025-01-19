package datastructures.lc240606;

public class Lc799 {
    public double champagneTower(int poured, int qRow, int qGlass) { // 4
        double[][] glasses = new double[qRow + 1][qRow + 1];
        glasses[0][0] = poured; // 4

        for (int row = 0; row < qRow; row++) {
            for (int glass = 0; glass <= row; glass++) {
                double overflow = (glasses[row][glass] - 1.0) / 2.0; // 3.0/2.0 = 1.5
                if (overflow > 0) {
                    glasses[row + 1][glass] += overflow;
                    glasses[row + 1][glass + 1] += overflow;

                }
            }
        }

        return Math.min(1, glasses[qRow][qGlass]);

    }
}
