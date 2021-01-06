package question1704_determine_if_string_halves_are_alike;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int count1 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (set.contains(s.charAt(i))) {
                count1++;
            }
        }
        int count2 = 0;
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count2++;
            }
        }
        return count1 == count2;
    }

}