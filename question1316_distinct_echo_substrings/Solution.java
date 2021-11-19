package question1316_distinct_echo_substrings;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int distinctEchoSubstrings(String text) {
    Set<String> result = new HashSet<>();
    for (int i = 0; i < text.length(); i++) {
      for (int j = i; j + j - i + 1< text.length(); j++) {
        // [i, j], [j + 1, j + j - i + 1]
        if (text.substring(i, j + 1).equals(text.substring(j + 1, j + j - i + 2))) {
          result.add(text.substring(i, j + 1));
        }
      }
    }
    System.out.println(result);
    return result.size();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().distinctEchoSubstrings("abcabcabc"));
  }

}