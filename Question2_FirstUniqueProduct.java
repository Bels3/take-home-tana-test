import java.util.LinkedHashMap;
import java.util.Map;

public class Question2_FirstUniqueProduct {
    public static String firstUniqueProduct(String[] products){
        Map<String, Integer> countMap = new LinkedHashMap<>();

        // Count occurrences of each product
        for(String product : products) {
            countMap.put(product, countMap.getOrDefault(product, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : countMap.entrySet() ) {
            if(entry.getValue() == 1) {
                return entry.getKey(); // Return the first unique product
            }
        }
        return null; // Return empty string if no unique product found
    }

    public static void main(String[] args){
        String[] test1 = {"apple", "computer", "orange", "apple", "kiwi"};
        System.out.println("First unique product: " + firstUniqueProduct(test1)); // Should print "computer"
        String[] test2 = {"apple", "banana", "apple", "banana"};
        System.out.println("First unique product: " + firstUniqueProduct(test2)); // Should print null
    }
}
