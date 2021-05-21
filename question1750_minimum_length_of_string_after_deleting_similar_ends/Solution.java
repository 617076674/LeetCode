package question1750_minimum_length_of_string_after_deleting_similar_ends;

public class Solution {

  public int minimumLength(String s) {
    int left = 0, right = s.length() - 1;
    while (right - left + 1 > 1) {
      if (s.charAt(left) != s.charAt(right)) {
        return right - left + 1;
      }
      while (left + 1 < right && s.charAt(left + 1) == s.charAt(left)) {
        left++;
      }
      while (right - 1 > left && s.charAt(right - 1) == s.charAt(right)) {
        right--;
      }
      left++;
      right--;
    }
    return right - left + 1;
  }

}