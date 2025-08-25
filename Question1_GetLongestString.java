import java.util.Arrays;
import java.util.List;

public class Question1_GetLongestString {
    public static String getLongestString(List<Character> validChars, List<String> strings) {
        String longestValid  = "";//variable initialized to empty string

        for (String str : strings) {
            if(isValid(str,validChars)){//values passed are checked against the valid characters
                if(str.length() > longestValid.length()) {
                    longestValid = str;//if the string is valid and longer the value is assigned to longestValid
                }
            }
        }
        return longestValid;
    }

    private static boolean isValid(String str, List<Character> validChars) {
        for (int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);
            // Check if the character is in the validChars list
            if(!validChars.contains(ch) && ch != ' ') {
                return false; // Invalid character found
            }
            if(i > 0 && ch == str.charAt(i-1)){
                return false; // Consecutive characters are not allowed
            }
        }
        return true;
    }
//This method tests the functionality of the getLongestString method
    public static void main(String[] args){
        List<Character> valid = Arrays.asList('A','B','C','D');
        List<String> input = Arrays.asList("AABCDA","ABCDZADC","ABCDBBCA","ABCDABDCA");
        String result = getLongestString(valid, input);
        System.out.println("Result: " + result); // Should print: ABCDABDCA
    }
}
