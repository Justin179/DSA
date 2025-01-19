package datastructures.lc240606;

public class Lc557 {
    public static void main(String[] args) {
        reverseWords("Let's take LeetCode contest");
    }

    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        for(int i = 0; i<strs.length; i++){
            String str = strs[i];
            strs[i] = reverseStr(str);
        }
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private static String reverseStr(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while(left<right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
