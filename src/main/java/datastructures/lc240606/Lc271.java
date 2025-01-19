package datastructures.lc240606;

import java.util.ArrayList;
import java.util.List;

public class Lc271 {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        // "we","say",":","yes","!@#$%^&*()"
        strs.add("we");
        strs.add("say");
        strs.add(":");
        strs.add("yes");
        strs.add("!@#$%^&*()");
        String encode = encode(strs);
        List<String> decode = decode(encode);
        System.out.println(decode);
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            int n = str.length();
            sb.append(n+"#");
            sb.append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        char[] chars = str.toCharArray();
        // 4#neet4#code -> 長度12
        while(i < chars.length){
            int j = i; // 0
            while(chars[j]!='#'){
                j++;
            }
            // 此時j為#的index
            int len = Integer.parseInt(str.substring(i,j));
            String temp = str.substring(j+1, j+1+len);
            ans.add(temp);
            i = j+1+len;
        }

        return ans;
    }
}
