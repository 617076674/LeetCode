package question1897_redistribute_characters_to_make_all_strings_equal;

public class Solution {

    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
        }
        for (int num : count) {
            if (num % words.length != 0) {
                return false;
            }
        }
        return true;
    }

}