package datastructures.lc240212;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc2352 {
    public static void main(String[] args) {
        int[][] grid = {{13,13},{13,13}};
        int result = equalPairs(grid);
        System.out.println(result);
    }

    public static int equalPairs(int[][] grid) {
        Map<String,Integer> rowMap = new HashMap<>();

        for(int[] row : grid){
            String rowKey = Arrays.toString(row);
            rowMap.put(rowKey,rowMap.getOrDefault(rowKey,0)+1);
        }

        int counter = 0;
        int length = grid.length;
        for(int i = 0; i<length; i++){
            int[] colArray = new int[length];
            for(int j = 0; j<length; j++){
                colArray[j] = grid[j][i];
            }
            String colKey = Arrays.toString(colArray);
            counter += rowMap.getOrDefault(colKey,0);
        }

        return counter;
    }

    /*
        public static int equalPairs(int[][] grid) {
        Map<String,Integer> rowMap = new HashMap<>();

        for(int[] row : grid){
            StringBuilder sb = new StringBuilder();
            for(int i : row){
                sb.append(i);
            }
            String key = sb.toString();
            rowMap.put(key,rowMap.getOrDefault(key,0)+1);
        }

        Map<String,Integer> columnMap = new HashMap<>();
        for(int i = 0; i<grid.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<grid.length; j++){ // 0 1 2 3
                sb.append(grid[j][i]);
            }
            String key = sb.toString();
            columnMap.put(key, columnMap.getOrDefault(key,0)+1);
        }

        int counter = 0;
        for(var entry : rowMap.entrySet()){
            String rowKey = entry.getKey();
            int rowValue = entry.getValue().intValue();
            if(columnMap.containsKey(rowKey)){
                int columnValue = columnMap.get(rowKey).intValue();
                int bigger = Math.max(rowValue,columnValue);
                counter+=bigger;
            }
        }
        return counter;
    }
     */



}
