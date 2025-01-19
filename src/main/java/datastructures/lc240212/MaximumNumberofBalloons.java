package datastructures.lc240212;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberofBalloons {
    public static void main(String[] args) {
        String text = "balllllllllllloooooooooon";
        int result = maxNumberOfBalloons(text);
        System.out.println(result);
    }

    public static int maxNumberOfBalloons(String text) {
        char[] chars = text.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char c : chars){
            if(c=='b'||c=='a'||c=='l'||c=='o'||c=='n'){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }

        int bs = map.getOrDefault('b',0).intValue();
        int as = map.getOrDefault('a',0).intValue();
        int ns = map.getOrDefault('n',0).intValue();
        int[] arr1 = new int[]{bs,as,ns};
        Arrays.sort(arr1);
        int small1 = arr1[0];

        int ls = map.getOrDefault('l',0).intValue();
        int os = map.getOrDefault('o',0).intValue();
        int[] arr2 = new int[]{ls,os};
        Arrays.sort(arr2);
        int small2 = arr2[0];

        if(small1<1 || small2<2){
            return 0;
        }

        for(int i = small1; i>0; i--){
            if( small2 >= (i*2)  ){
                return i;
            }
        }


        return 0;
    }
}
