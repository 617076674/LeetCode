package question2062_count_vowel_substrings_of_a_string;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int countVowelSubstrings(String word) {
    int result = 0;
    for (int i = 0; i < word.length(); i++) {
      for (int j = i; j < word.length(); j++) {
        Set<Character> set = new HashSet<>();
        boolean flag = true;
        for (int k = i; k <= j; k++) {
          char c = word.charAt(k);
          if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            set.add(c);
          } else {
            flag = false;
            break;
          }
        }
        if (flag && set.size() == 5) {
          result++;
        }
      }
    }
    return result;
  }

}