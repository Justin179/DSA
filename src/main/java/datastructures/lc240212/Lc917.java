package datastructures.lc240212;

public class Lc917 {
    public static void main(String[] args) {

    }

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i<j){
            if( Character.isLetter(chars[i]) && Character.isLetter(chars[j]) ){ // 兩者皆英文字
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if (Character.isLetter(chars[j])){ // 右邊英文字
                i++;
            } else if (Character.isLetter(chars[i])){ // 左邊英文字
                j--;
            } else { // 沒有英文字
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}
