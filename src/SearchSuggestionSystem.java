import java.util.*;

/**
 * <a href="https://leetcode.com/problems/search-suggestions-system/description/">...</a>
 */

public class SearchSuggestionSystem {


    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList();

        TreeMap<String, Integer> map = new TreeMap();

        List<String> productList = Arrays.asList(products);

        Arrays.sort(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        StringBuilder key = new StringBuilder();

        for (char c : searchWord.toCharArray()) {
            key.append(c);

            String ceiling = map.ceilingKey(key.toString());
            String floor = map.floorKey(key + "~");

            if (ceiling == null || floor == null) break;
            res.add(productList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList());

        return res;
    }

    public static void main(String[] args) {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};

        String searchWord = "mouse";

        System.out.println(suggestedProducts(products, searchWord));


    }
}
