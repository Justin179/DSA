package datastructures.lc240606;

import java.util.Arrays;

public class Lc948 {
    public static void main(String[] args) {
        int[] tokens = new int[]{50,50,50,100};
        int power = 50;
        int res = bagOfTokensScore(tokens, power);
    }
    public static int bagOfTokensScore(int[] tokens, int power) {
        // 50 50 50 100    50
        int n = tokens.length;
        int score = 0;
        Arrays.sort(tokens);
        int left = 0, right = n - 1;
        int maxScore = 0;
        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[right--];
                score--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
