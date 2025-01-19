package datastructures.lc240330;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Lc399_2 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 建圖
        HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);

        double[] finalAns = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0); // a
            String divisor = queries.get(i).get(1); // c

            if (!gr.containsKey(dividend) || !gr.containsKey(divisor)) { // 缺料 像是x
                finalAns[i] = -1.0;
            } else {
                // 不缺料就dfs
                HashSet<String> vis = new HashSet<>(); // 記錄走過的
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(dividend, divisor, gr, vis, ans, temp);
                finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }

    public void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> gr, HashSet<String> vis, double[] ans, double temp) {
        // node a b c
        // dest c c c
        // gr圖
        // vis記錄走過的
        // ans 裝結果
        // temp 固定1.0

        // 走過的不走
        if (vis.contains(node)) // 防回頭
            return;

        // 走過留下記錄
        vis.add(node); // a b c

        if (node.equals(dest)) { // ab bc cc
            ans[0] = temp;
            return;
        }

        for (Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
            String ne = entry.getKey(); // to b    c
            double val = entry.getValue(); // 需 2     3
            dfs(ne, dest, gr, vis, ans, temp * val); // 1*2   2*3
        }
    }

    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        // a點    a點的鄰居與長度
        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0); // a
            String divisor = equations.get(i).get(1); // b
            double value = values[i]; // 2.0

            gr.putIfAbsent(dividend, new HashMap<>()); // a 不存在就先放一個空的map
            gr.putIfAbsent(divisor, new HashMap<>()); // b 不存在就先放一個空的map

            gr.get(dividend).put(divisor, value); // a放b 2.0
            gr.get(divisor).put(dividend, 1.0 / value); // b放a 1/2.0
        }

        return gr;
    }
    /* 圖長這樣
    a   b:2

    b   a:1/2
        c:3

    c   b:1/3
     */





}