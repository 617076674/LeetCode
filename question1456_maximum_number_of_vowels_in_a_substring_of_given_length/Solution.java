package question1456_maximum_number_of_vowels_in_a_substring_of_given_length;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int maxVowels(String s, int k) {
    int[] sum = new int[s.length() + 1];
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    for (int i = 1; i < sum.length; i++) {
      sum[i] = sum[i - 1];
      if (set.contains(s.charAt(i - 1))) {
        sum[i]++;
      }
    }
    int result = 0;
    for (int i = 0; i + k - 1 < s.length(); i++) {
      result = Math.max(result, sum[i + k] - sum[i]);
    }
    return result;
  }

}