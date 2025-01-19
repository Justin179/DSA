package datastructures.lc240212;

public class Lc953 {
    int[] charsOrderDictionary = new int[26]; // 記錄每一個字元應有的順序，例如a在外星人字典的順序為2
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i<order.length(); i++){
            charsOrderDictionary[order.charAt(i) - 'a'] = i;
        }
        for(int i = 1; i<words.length; i++){
            if(compare(words[i-1],words[i]) > 0){
                return false;
            }
        }

        return true;
    }

    private int compare(String word1, String word2) { // 正數 = 順序錯
        int i = 0;
        int j = 0;
        int orderCheck = 0;
        while (i<word1.length()&&j<word2.length()&& orderCheck==0){
            orderCheck = charsOrderDictionary[word1.charAt(i)-'a'] - charsOrderDictionary[word2.charAt(j)-'a'];
            i++;
            j++;
        }
        if(orderCheck==0){ // app apple
            return word1.length() - word2.length();
        } else {
            return orderCheck;
        }
    }
}
