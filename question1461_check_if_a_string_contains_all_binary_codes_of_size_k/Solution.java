package question1461_check_if_a_string_contains_all_binary_codes_of_size_k;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public boolean hasAllCodes(String s, int k) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i + k - 1 < s.length(); i++) {
      // [i, i + k - 1]
      set.add(s.substring(i, i + k));
    }
    return set.size() == Math.pow(2, k);
  }

}