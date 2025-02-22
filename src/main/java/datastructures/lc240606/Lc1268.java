package datastructures.lc240606;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        /* mouse
             "mobile"
            ,"moneypot"
            ,"monitor"
            ,"mouse"
            ,"mousepad"
         */
        List<List<String>> ans = new ArrayList<List<String>>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);  // current prefix
            List<String> matches = new ArrayList<>();

            // Check the products to see if they match the current prefix
            for (String product : products) {
                if (product.startsWith(prefix)) {
                    matches.add(product);
                    if (matches.size() == 3) { // only add up to 3 matches
                        break;
                    }
                }
            }
            ans.add(matches); // add the matches for this prefix
        }
        return ans;

    }
}
