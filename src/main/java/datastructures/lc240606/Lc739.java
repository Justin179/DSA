package datastructures.lc240606;

import java.util.Arrays;
import java.util.Stack;

public class Lc739 {
    public static void main(String[] args) {
        int[] temp = new int[]{73,74,75,71,69,72,76,73};
        dailyTemperatures(temp);
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Arrays.fill(result,0);
        Stack<int[]> stack = new Stack<>(); // 左 temperature 右 index
        for(int i = 0; i<length; i++){
            int currTemp = temperatures[i];
            int[] currItem = new int[]{currTemp,i}; // 左 temperature 右 index

            while (!stack.isEmpty() && stack.peek()[0] < currTemp){
                int popPos = stack.pop()[1]; // 執行pop的同時取出其index
                result[popPos] = i-popPos;
            }

            if(stack.isEmpty() || stack.peek()[0] >= currTemp){
                stack.push(currItem);
            }
        }
        
        return result;
    }
}
