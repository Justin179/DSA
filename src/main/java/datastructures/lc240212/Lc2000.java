package datastructures.lc240212;

public class Lc2000 {
    public static void main(String[] args) {
//        word = "abcdefd", ch = "d"
        String word = "abcdefd";
        char ch = 'd';
        String str = reversePrefix(word,ch);
        System.out.println(str);
    }

    public static String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int index = 0;
        for(int i = 0; i<chars.length; i++){
            if(chars[i] == ch){
                index = i;
                break;
            }
        }

        int start = 0;
        while(start<index){
            char temp = chars[start];
            chars[start] = chars[index];
            chars[index] = temp;

            start++;
            index--;
        }

        return new String(chars);
    }
}
