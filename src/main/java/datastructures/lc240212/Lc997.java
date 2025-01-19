package datastructures.lc240212;

import java.util.HashMap;
import java.util.Map;

public class Lc997 {
    /*
    incoming: n-1
    outgoing: 0
     */
    public int findJudge(int n, int[][] trust) {

        Map<Integer,Integer> incoming = new HashMap<>();
        Map<Integer,Integer> outgoing = new HashMap<>(); // trust others
        for(int[] curr : trust){
            int toTrust = curr[0];
            int beTrusted = curr[1];
            outgoing.put(toTrust,outgoing.getOrDefault(toTrust,0)+1);
            incoming.put(beTrusted,incoming.getOrDefault(beTrusted,0)+1);
        }
        for(var temp: incoming.entrySet()){
            if(temp.getValue()==n-1){
                int suspect = temp.getKey();
                if(outgoing.get(suspect)!=null && outgoing.get(suspect) == 0)
                    return suspect;
            }
        }
        return -1;
    }
}
