package question1941_check_if_all_characters_have_equal_number_of_occurrences;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                set.add(count[i]);
            }
        }
        return set.size() == 1;
    }

}