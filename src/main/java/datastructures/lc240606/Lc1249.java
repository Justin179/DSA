package datastructures.lc240606;

public class Lc1249 {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        minRemoveToMakeValid(s);
    }
    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char c : chars){
            if(c=='('){
                open++;
            } else if(c==')'){
                if(open==0){
                    continue;
                }
                open--;
            }
            sb.append(c);
        }

        if(open>0){
            StringBuilder sb2 = new StringBuilder();
            for(int i = sb.length()-1; i>=0; i--){
                char c = sb.charAt(i);
                if(c=='(' && open>0){
                    open--;
                    continue;
                }
                sb2.append(c);
            }
            String result = sb2.reverse().toString();
            return result;
        } else {
            return sb.toString();
        }

    }
}
