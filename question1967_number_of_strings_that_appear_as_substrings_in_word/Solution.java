package question1967_number_of_strings_that_appear_as_substrings_in_word;

public class Solution {

    public int numOfStrings(String[] patterns, String word) {
        int result = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                result++;
            }
        }
        return result;
    }

}