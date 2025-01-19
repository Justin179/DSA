package datastructures.lc240330;

public class Lc28 {

    public static void main(String[] args) {
        int i = strStr("abc", "c");
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {
        if(haystack==null||needle==null){
            return -1;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        if(needle.isEmpty()){
            return 0;
        }
        if(haystack.length()==needle.length() && haystack.equals(needle)){
            return 0;
        }


        for(int i = 0; i<haystack.length()-needle.length(); i++){
            if(haystack.charAt(i)==needle.charAt(0)){ // i = 0,
                boolean found = true;
                for(int j = 0; j<needle.length(); j++){
                    char right = needle.charAt(j);
                    int temp = i+j;
                    char left = haystack.charAt(temp);
                    if(left!=right){
                        found = false;
                        break;
                    }
                }
                if(found){
                    return i;
                }
            }
        }




        return -1;
    }
}
