package datastructures.lc240606;

import java.util.Arrays;
import java.util.Stack;

public class Lc853_2 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] posAndSpeed = new double[n][2];
        for(int i = 0; i<n; i++){ // 0 1 2
            int pos = position[i];
            int spe = speed[i];
            posAndSpeed[i][0] = pos;
            posAndSpeed[i][1] = spe;
        }
        Arrays.sort(posAndSpeed,(a,b)-> Double.compare(a[0],b[0])); // 3 5 7
        Stack<Double> stack = new Stack<>();
        for(int i = n-1; i>=0; i--){
            double pos = posAndSpeed[i][0];
            double spe = posAndSpeed[i][1];
            double timeRequired = (target-pos) / spe;
            if(!stack.isEmpty() && stack.peek()>=timeRequired){ // 到終點前，所需要的時間更少 = 會撞上 = 不用放
                continue;
            }
            stack.push(timeRequired);
        }
        return stack.size();
    }
}
