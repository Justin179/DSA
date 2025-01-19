package datastructures.lc240606;

import java.util.Arrays;

public class Lc948_2 {
    public static void main(String[] args) {
        int[] tokens = new int[]{50,50,50,100};
        int power = 50;
        int res = bagOfTokensScore(tokens, power);
    }
    public static int bagOfTokensScore(int[] tokens, int power) {
        // 50 50 50 100    50
        int score = 0;
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int maxScore = 0;
        // 目前是分數最大化
        while (left <= right) {
            if (tokens[left] <= power) { // 力還夠時，拿力換分
                power -= tokens[left];  // 減力
                score++;                // 加分
                left++;                 // 換到走
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) { // 力不夠時，拿分換力
                score--;                // 減分
                power += tokens[right]; // 加力
                right--;                // 換到走
            } else { // 非上2情況，跳出loop
                break;
            }
        }
        return maxScore;
    }
}
