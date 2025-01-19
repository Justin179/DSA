package datastructures.lc240330;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc547 {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,0},{1,1,0},{0,0,1}};

    }

    static void dfs(int arr[][], int visited[], int i){
        for(int j=0; j<arr.length; j++){ // 掃過每一個子元素
            if(arr[i][j]==1 && visited[j]==0){ // 相連且沒到過的元素，標記為到過
                visited[j]=1;
                dfs(arr,visited,j);
            }
        }
    }
    public static int findCircleNum(int[][] arr) {
        int n = arr.length;
        int visited[] = new int[n]; // [0,0,0]
        int ans = 0;

        for(int i=0; i<n; i++){
            if(visited[i]==0){
                ans++;
                dfs(arr,visited,i);
            }
        }
        return ans;
    }
}
