package question1347_minimum_number_of_steps_to_make_two_strings_anagram;

public class Solution {

    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i) - 'a'] == 0) {
                result++;
            } else {
                map[t.charAt(i) - 'a']--;
            }
        }
        return result;
    }

}