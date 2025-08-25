import java.util.*;
import java.util.stream.Collectors;

public class Question4_Common3Words {
    public static List<String> getTopThreeWords(String sentence){
        String[] words = sentence.toLowerCase().split("\\s+");
        Map<String,Integer> freqMap = new HashMap<>();

        // Count frequency of each word
        for(String word : words){
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        //Sort entries by frequency
        List<String> topWords = freqMap.entrySet().stream()
                .sorted((a, b) -> b.getValue() - (a.getValue()))// Sort by frequency descending
                .limit(3) // Get top 3
                .map(Map.Entry::getKey) // Extract words
                .collect(Collectors.toList()); // Collect to list
        //sort alphabetically
        Collections.sort(topWords);

        return topWords;
    }
//testing the functionality of the getTopThreeWords method
    public static void main(String[] args) {
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        List<String> topWords = getTopThreeWords(sentence);
        System.out.println("Top 3 words: " + topWords);
    }
}
