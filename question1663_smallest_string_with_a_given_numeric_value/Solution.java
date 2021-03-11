package question1663_smallest_string_with_a_given_numeric_value;

public class Solution {

  public String getSmallestString(int n, int k) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
          int min = k - 26 * (n - i - 1);
          if (min <= 1) {
              sb.append('a');
              k--;
          } else {
              sb.append((char) ('a' + min - 1));
              k -= min;
          }
      }
      return sb.toString();
  }

}