package question1910_remove_all_occurrences_of_a_substring;

public class Solution {
    public String removeOccurrences(String s, String part) {
        while (true) {
            int index = s.indexOf(part);
            if (index == -1) {
                return s;
            }
            s = s.substring(0, index) + s.substring(index + part.length());
        }
    }
}