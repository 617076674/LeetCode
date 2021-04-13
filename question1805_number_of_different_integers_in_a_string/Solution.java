package question1805_number_of_different_integers_in_a_string;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numDifferentIntegers(String word) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                int j = i;
                while (j + 1 < word.length() && Character.isDigit(word.charAt(j + 1))) {
                    j++;
                    num = num * 10 + word.charAt(j) - '0';
                }
                set.add(num);
                i = j;
            }
        }
        return set.size();
    }

}