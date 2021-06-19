package question1876_substrings_of_size_three_with_distinct_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int countGoodSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (check(s, i, i + 2)) {
                result++;
            }
        }
        return result;
    }

    private static boolean check(String s, int left, int right) {
        Set<Character> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            set.add(s.charAt(i));
        }
        return set.size() == 3;
    }

}