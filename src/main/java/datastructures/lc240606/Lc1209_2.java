package datastructures.lc240606;

import java.util.ArrayDeque;

public class Lc1209_2 {
    public String removeDuplicates(String s, int k) {
        // ArrayDeque has better performance than Stack and LinkedList
        ArrayDeque<Adjacent> st = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!st.isEmpty()&&st.peekLast().c==c){
                st.peekLast().freq++;
            }else {
                st.addLast(new Adjacent(c,1));
            }
            if(st.peekLast().freq==k)
                st.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        for(Adjacent a : st){
            sb.append(String.valueOf(a.c).repeat(a.freq));
        }
        return sb.toString();
    }

    class Adjacent{
        char c;
        int freq;
        public Adjacent(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
