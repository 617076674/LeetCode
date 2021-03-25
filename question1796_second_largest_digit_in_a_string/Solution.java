package question1796_second_largest_digit_in_a_string;

public class Solution {

  public int secondHighest(String s) {
      int max = -1, result = -1;
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (!Character.isDigit(c)) {
              continue;
          }
          int num = c - '0';
          if (num > max) {
              result = max;
              max = num;
          }
          if (num < max && num > result) {
              result = num;
          }
      }
      return result;
  }

}