package datastructures.lc240606;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc1268_2 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        /* products:       search:mouse
             "mobile"
            ,"moneypot"
            ,"monitor"
            ,"mouse"
            ,"mousepad"
         */
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        for(int i = 1; i<=searchWord.length(); i++){
            String prefix = searchWord.substring(0, i);
            List<String> temp = new ArrayList<>();
            for(String product : products){ // 5轉
                if(product.startsWith(prefix)){
                    temp.add(product);
                }
                if (temp.size()==3){
                    break;
                }
            }
            ans.add(temp);
        }

        return ans;
    }
}
