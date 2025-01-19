package datastructures.lc240606;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs.length == 1){
            List<String> temp = new ArrayList<>();
            temp.add(strs[0]);
            ans.add(temp);
            return ans;
        }

        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            String key = sortStr(str);
            if(map.get(key)==null){
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key,temp);
            }else{
                List<String> strings = map.get(key);
                strings.add(str);
            }
        }

        for(List<String> list : map.values()){
            ans.add(list);
        }
        return ans;
    }

    public static String sortStr(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
