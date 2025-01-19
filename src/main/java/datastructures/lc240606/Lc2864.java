package datastructures.lc240606;

public class Lc2864 {
    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars){
            if(c=='1')
                count++;
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length(); // 4
        count = count-1; // 1
        for (int i = 0; i<length-1; i++){
            if(count>0){
                sb.append("1");
                count--;
            } else
                sb.append("0");
        }
        return sb.append("1").toString();
    }
}
