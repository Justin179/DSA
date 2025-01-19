package datastructures.lc240212;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lc2434 {

    public static void main(String[] args) {
        String s = "cbaabc";
        robotWithString(s);
    }


   public static String robotWithString(String s) {
       StringBuilder ans = new StringBuilder();
       Stack<Character> t = new Stack<>();
       char[] schar = s.toCharArray(); // "cbaabc"

       Map<Character, Integer> map = new HashMap<>();
       for(int i = 0; i < s.length(); i++)
           map.put(schar[i], i);
       Arrays.sort(schar); // aabbcc

       int cur = -1;
       int i = 0;
       while(i < s.length()){ // 0 1 2 3 4 5
           char curch = schar[i];//Check current minimum character -> a

           if(map.get(curch) > cur){ //Current char is not in stack

               while(!t.isEmpty() && t.peek() <= curch)
                   ans.append(t.pop());//Char in stack is smaller than current char, then we add it to answer first

               ans.append(curch);

               for(int j = cur + 1; j < map.get(curch); j++){
                   if(s.charAt(j) == curch){
                       ans.append(curch);
                       i++;
                   }
                   else t.push(s.charAt(j)); //Put in stack
               }
               cur = map.get(curch);
           }

           i++;
       }

       //Add left nums in stack to answer
       while(!t.isEmpty())
           ans.append(t.pop());
       return ans.toString();
   }


}
