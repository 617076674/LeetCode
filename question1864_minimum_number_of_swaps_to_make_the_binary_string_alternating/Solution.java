package question1864_minimum_number_of_swaps_to_make_the_binary_string_alternating;

public class Solution {

  public int minSwaps(String s) {
    int count1 = 0, count0 = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '0') {
        count0++;
      } else {
        count1++;
      }
    }
    if (Math.abs(count0 - count1) > 1) {
      return -1;
    }
    int result1 = 0, result2 = 0;
    for (int i = 0; i < s.length(); i++) {
      if ((i & 1) == 0) {
        if (s.charAt(i) == '0') {
          result1++;
        }
      } else {
        if (s.charAt(i) == '1') {
          result1++;
        }
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if ((i & 1) == 0) {
        if (s.charAt(i) == '1') {
          result2++;
        }
      } else {
        if (s.charAt(i) == '0') {
          result2++;
        }
      }
    }
    if (count0 > count1) {
      return result2 / 2;
    }
    if (count0 < count1) {
      return result1 / 2;
    }
    return Math.min(result1 / 2, result2 / 2);
  }

}