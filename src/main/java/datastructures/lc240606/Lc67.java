package datastructures.lc240606;

public class Lc67 {
    public static void main(String[] args) {
        addBinary("1010","1011");
    }
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0){
            int sum = carry;
            int currA = i>=0? a.charAt(i) - '0' : 0;
            int currB = j>=0? b.charAt(j) - '0' : 0;
            // sum => 0 1 2 3 %2 => 0 1 0 1
            // sum => 0 1 2 3 /2 => 0 0 1 1
            sum+=currA+currB;
            sb.insert(0,sum%2);
            carry = sum/2;
            i--;
            j--;
        }
        if(carry==1)
            sb.insert(0,"1");
        return sb.toString();
    }
}
