package datastructures.lc240606;

import java.util.HashSet;

public class Lc929 {
    // ignore local .
    // local +後的無視
    public static void main(String[] args) {
        String[] emails = new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        numUniqueEmails(emails);
    }
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String email : emails){
            int index = email.indexOf("@");
            String a = email.substring(0,index); // a b c
            String b = email.substring(index);
            int tempI = a.indexOf("+");
            if(tempI!=-1){
                a = a.substring(0,tempI);
            }
            a = a.replaceAll("\\.","");
            String newStr = a+b;
            set.add(newStr);
        }
        return set.size();
    }
}
