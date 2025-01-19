package datastructures.lc240212;

public class Lc1456 {
    public static void main(String[] args) {
        String s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb";
        int k = 33;
        int result = maxVowels(s,k);
        System.out.println(result);
    }

    public static int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();


        int vowelCounter = 0;
        // first
        for(int i = 0; i<k;i++){
            char currChar = chars[i];
            if(currChar=='a'||currChar=='e'||currChar=='i'||currChar=='o'||currChar=='u'){
                vowelCounter++;
            }
        }
        int maxVowel = vowelCounter;

        for(int i = 1; (i+k-1)<chars.length; i++){
            char prev = chars[i-1];
            char next = chars[i+k-1];
            if(prev=='a'||prev=='e'||prev=='i'||prev=='o'||prev=='u'){
                vowelCounter-=1;
            }
            if(next=='a'||next=='e'||next=='i'||next=='o'||next=='u'){
                vowelCounter+=1;
            }
            maxVowel = Math.max(maxVowel, vowelCounter);
        }


        return maxVowel;
    }
}
