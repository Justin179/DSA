package datastructures.lc240330;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Lc399 {
    // a : a的鄰居與距離
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0); // a(分子)
            String denominator = equations.get(i).get(1); // b(分母)
            double val = values[i]; // 2.0

            // 分子不存在於map，就先放一個空的map
            if (!graph.containsKey(numerator)) {
                graph.put(numerator, new HashMap<>());
            }
            // 分母不存在於map，就先放一個空的map
            if (!graph.containsKey(denominator)) {
                graph.put(denominator, new HashMap<>());
            }

            // 雙向圖
            // 拿分子，放分母
            graph.get(numerator).put(denominator, val);
            // 拿分母，放分子
            graph.get(denominator).put(numerator, 1 / val);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            ans[i] = answerQuery(queries.get(i).get(0), queries.get(i).get(1));
        }

        return ans;
    }


    public double answerQuery(String start, String end) { // a c
        // no info on this node
        if (!graph.containsKey(start)) {
            return -1;
        }

        Set<String> seen = new HashSet<>();
        Stack<Pair> stack = new Stack<>();
        seen.add(start);
        stack.push(new Pair(start, 1));
        while (!stack.empty()) {
            Pair pair = stack.pop();
            String node = pair.node; // a
            double ratio = pair.ratio; // 1
            if (node.equals(end)) {
                return ratio;
            }

            if (graph.containsKey(node)) { // a
                for (String neighbor: graph.get(node).keySet()) { // a的鄰居
                    if (!seen.contains(neighbor)) { // 沒走過的鄰居
                        seen.add(neighbor); // b
                        stack.push(new Pair(neighbor, ratio * graph.get(node).get(neighbor)));
                    }
                }
            }
        }

        return -1;
    }
}
