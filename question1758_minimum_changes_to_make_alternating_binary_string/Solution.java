package question1758_minimum_changes_to_make_alternating_binary_string;

public class Solution {

   public int minOperations(String s) {
    int result1 = 0, result2 = 0;
    for (int i = 0; i < s.length(); i++) {
      if ((i & 1) == 0) {
        if (s.charAt(i) == '0') {
          result1++;
        } else {
          result2++;
        }
      } else {
        if (s.charAt(i) == '1') {
          result1++;
        } else {
          result2++;
        }
      }
    }
    return Math.min(result1, result2);
  }

}