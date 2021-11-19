package question0828_count_unique_characters_of_all_substrings_of_a_given_string;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static int MOD = 1000000007;

  public int uniqueLetterString(String s) {
      List<Integer>[] lists = new List[26];
      for (int i = 0; i < lists.length; i++) {
          lists[i] = new ArrayList<>();
      }
      for (int i = 0; i < s.length(); i++) {
          lists[s.charAt(i) - 'A'].add(i);
      }
      int result = 0;
      for (int i = 0; i < lists.length; i++) {
          if (lists[i].isEmpty()) {
              continue;
          }
          int index = 0;
          for (int j = 0; j < s.length(); j++) {
              int left = lists[i].get(index),
                  right = (index + 1 < lists[i].size() ? lists[i].get(index + 1) : s.length()) - 1;
              result += right - left + 1;
              result %= MOD;
              if (j == lists[i].get(index)) {
                  index++;
                  if (index >= lists[i].size()) {
                      break;
                  }
              }
          }
      }
      return result;
  }

}